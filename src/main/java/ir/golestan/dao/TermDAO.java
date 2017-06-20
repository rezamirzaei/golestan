package ir.golestan.dao;

import ir.golestan.model.Term;
import ir.golestan.model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;

/**
 * Created by Reza-PC on 6/19/2017.
 */
@Repository
public class TermDAO {

    @Autowired
    @Qualifier("sessionFactory")
    SessionFactory sessionFactory;

    public void create(Term term){
        sessionFactory.getCurrentSession().save(term);
    }
    public void delete(Term term){
        sessionFactory.getCurrentSession().delete(term);
    }
    public Term load(Long code){
         Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Term.class);
        criteria.add(Restrictions.eq("code", code));
        List<Term> list = criteria.list();
       if(list == null||list.size()==0){
           return null;
       }
       return list.get(0);
    }

    public void update(Term term){
        sessionFactory.getCurrentSession().update(term);
    }
    public Term getById(Long id){
       return sessionFactory.getCurrentSession().load(Term.class,id);
    }
    public List<Term> loadAll(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Term.class);
        return criteria.list();
    }
}
