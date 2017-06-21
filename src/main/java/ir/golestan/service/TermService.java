package ir.golestan.service;

import ir.golestan.dao.TermDAO;
import ir.golestan.model.Term;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Reza-PC on 6/20/2017.
 */
@Service
public class TermService {

    @Autowired
    HttpSession httpSession;
    @Autowired
    TermDAO termDAO;

    @Transactional
    public Term load(Long code) {
        return termDAO.load(code);
    }

    @Transactional
    public List<Term> loadAll() {
        return termDAO.loadAll();
    }

    @Transactional
    public void deleteByCode(Long code) {
        Term term = load(code);
        this.delete(term);
    }

    @Transactional
    public void delete(Term term) {
        termDAO.delete(term);
    }
    @Transactional
    public void create(Term term){
        termDAO.create(term);
    }

}
