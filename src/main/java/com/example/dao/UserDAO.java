package com.example.dao;

import com.example.model.Book;
import com.example.model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Reza-PC on 1/16/2017.
 */
@Repository
public class UserDAO {
@Autowired
    SessionFactory sessionFactory ;
    public void create(User user){
        sessionFactory.getCurrentSession().save(user);
    }
    public void update(User user){
        sessionFactory.getCurrentSession().update(user);
    }
    public void delete(User user){
        sessionFactory.getCurrentSession().delete(user);
    }
    public User load(Long id){
        return sessionFactory.getCurrentSession().get(User.class,id);
    }
    public User login(String email,String password){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("email",email));
        List<User> list=criteria.list();
        if(list!=null&&list.size()>0){
             User user =  list.get(0);
            if(user.getPassword()==password){
                return user;
            }
        }
        return null;
    }
    public boolean validNewUser(User user){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("email",user.getEmail()));
         List<Book> list=criteria.list();
        if(list!=null&&list.size()>0){
            return false ;
        }
        return true;
    }

}
