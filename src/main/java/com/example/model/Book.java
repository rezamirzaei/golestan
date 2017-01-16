package com.example.model;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by Reza-PC on 1/15/2017.
 */
@Entity
@Table(name = "BS_BOOK")
public class Book {
    @Id
    @Column(name="BOOK_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @Column
    private String writer;
    @Column
    private String about;
    @Column
    private float rank;
    @Column
    private int countOfUserRankIt;
    @Column
    private Date dateAdded;
    @Column
    private String Category;
    @Column
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Book(String name) {
        this.name = name;
    }

    public Book(String name, String writer, String about, float rank, int countOfUserRankIt, Date dateAdded, String Category, String price) {
        this.name = name;
        this.writer = writer;
        this.about = about;
        this.rank = rank;
        this.countOfUserRankIt = countOfUserRankIt;
        this.dateAdded = dateAdded;
        this.Category = Category;
        this.price = price;
    }

    public Book(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public float getRank() {
        return rank;
    }

    public void setRank(float rank) {
        this.rank = rank;
    }

    public int getCountOfUserRankIt() {
        return countOfUserRankIt;
    }

    public void setCountOfUserRankIt(int countOfUserRankIt) {
        this.countOfUserRankIt = countOfUserRankIt;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        this.Category = category;
    }

}
