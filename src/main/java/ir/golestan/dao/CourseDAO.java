package ir.golestan.dao;

import ir.golestan.model.Course;
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

    public List getAll() {
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
}
