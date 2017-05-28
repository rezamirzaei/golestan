package ir.golestan.dao;

import ir.golestan.model.Book;
import ir.golestan.model.User;
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
public class UserDAO implements DaoInterface<User,String> {
    @Autowired
    @Qualifier("sessionFactory")
    SessionFactory sessionFactory;

    public void create(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public User getById(String id) {
        return sessionFactory.getCurrentSession().get(User.class,id);
    }

    @Override
    public List<User> getAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        return criteria.list();
    }
    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }
    @Override
    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    public User load(String username) {
        return sessionFactory.getCurrentSession().get(User.class,username);
    }

    public User login(String username, String password) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
         User user=load(username);

        System.out.println(user.getPassword());
            if (user!=null &&user.getPassword().equals(password)) {
                return user;
            }

        return null;
    }

    public boolean validNewUser(String username) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        List<Book> list = criteria.list();
        if (list != null && list.size() > 0) {
            return false;
        }
        return true;
    }

}
