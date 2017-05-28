package ir.golestan.model;

import javax.persistence.*;
import java.time.Year;

/**
 * Created by Reza-PC on 5/28/2017.
 */
@Entity
public class Term {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    int year;
    @Column
    int season;
    @Column
    Long Code;
    public Term(){

    }

    public Term(int year, int season, Long code) {
        this.year = year;
        this.season = season;
        Code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public Long getCode() {
        return Code;
    }

    public void setCode(Long code) {
        Code = code;
    }
}
