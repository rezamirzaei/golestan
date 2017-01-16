package com.example.dao;

import com.example.model.Book;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Reza-PC on 1/16/2017.
 */

@Repository
public class BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Book> getOrderedBooks(int start, int len, String orderBy)
    {
       Criteria criteria =sessionFactory.getCurrentSession().createCriteria(Book.class);
        criteria.addOrder(Order.desc(orderBy)).setFirstResult(start).setMaxResults(len);
        return criteria.list();
    }
    public List<Book> loadAll(){
      Criteria criteria  = sessionFactory.getCurrentSession().createCriteria(Book.class);
        return criteria.list();
    }
    public Book Load(Long id){
       return (Book)sessionFactory.getCurrentSession().get(Book.class,id);
    }
    public void create(Book book){
        sessionFactory.getCurrentSession().save(book);
    }
    public void update(Book book){
        sessionFactory.getCurrentSession().update(book);
    }
    public void delete(Book book){
        sessionFactory.getCurrentSession().delete(book);
    }
    public List<String> loadTopRecentWriter(int count){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Book.class);
        criteria.addOrder(Order.desc("id")).setProjection(Projections.distinct(Projections.property("writer"))).setFirstResult(0).setMaxResults(count);
        return criteria.list();
    }
    public List<String> loadTopRecentCategory(int count){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Book.class);
        criteria.addOrder(Order.desc("id")).setProjection(Projections.distinct(Projections.property("category"))).setFirstResult(0).setMaxResults(count);
        return criteria.list();
    }
}
