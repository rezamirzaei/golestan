package ir.golestan.model;

import org.springframework.stereotype.Repository;

/**
 * Created by Reza-PC on 6/23/2017.
 */
@Repository
public class ThisTerm {
   Term term;

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }
}
