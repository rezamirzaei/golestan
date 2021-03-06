package ir.golestan.dao;

import ir.golestan.model.Course;
import ir.golestan.model.Term;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Reza-PC on 5/28/2017.
 */
@Repository
public class CourseDAO {
    @Autowired
    @Qualifier("sessionFactory")
    SessionFactory sessionFactory;

    public void create(Course course) {
        sessionFactory.getCurrentSession().save(course);
    }

    public Course getById(Long id) {
        return (Course) sessionFactory.getCurrentSession().get(Course.class, id);
    }

    public List<Course> getAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Course.class);
        return criteria.list();
    }

    public List getByName(String name) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Course.class);
        criteria.add(Restrictions.eq("name", name));
        List<Course> list = criteria.list();
        return list;
    }

    public void delete(Course course) {
        sessionFactory.getCurrentSession().delete(course);
    }

    public void update(Course course) {
        sessionFactory.getCurrentSession().update(course);
    }

    public Course load(Long code) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Course.class);
        criteria.add(Restrictions.eq("code", code));
        List<Course> list = criteria.list();
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }
}
