package ir.golestan.dao;

import ir.golestan.model.Teacher;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Reza-PC on 6/23/2017.
 */
@Repository
public class TeacherDAO {
    @Autowired
    SessionFactory sessionFactory;
    public void create(Teacher teacher){
        sessionFactory.getCurrentSession().save(teacher);
    }
    public void update(Teacher teacher){
        sessionFactory.getCurrentSession().update(teacher);
    }
    public void delete(Teacher teacher){
        sessionFactory.getCurrentSession().delete(teacher);
    }
    public Teacher load(String username){
        return sessionFactory.getCurrentSession().load(Teacher.class,username);
    }

}
