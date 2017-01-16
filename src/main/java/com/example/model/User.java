package com.example.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

/**
 * Created by Reza-PC on 1/15/2017.
 */
@Entity
@Table(name ="BS_USER")
public class User {
    @Id
    @Column(name ="USER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="password",nullable = false)
    private String password;
    @Column(name="email",nullable = false,unique = true)
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            +"[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            +"(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            message="{invalid.email}")
    private String email;
    @Column(name = "rule")
    private String Rule;
    public String getRule() {
        return Rule;
    }

    public void setRule(String rule) {
        Rule = rule;
    }

    public User(String password, String email, String rule, String city, String address, String phone) {
        this.password = password;
        this.email = email;
        Rule = rule;
        this.city = city;
        this.address = address;
        this.phone = phone;
    }

    @Column(name="city")
    private String city;
    @Column(name="address")
    private String address;
    @Column(name="phone")
    private String phone;

    public User(String password, String email, String city, String address, String phone) {
        this.password = password;
        this.email = email;
        this.city = city;
        this.address = address;
        this.phone = phone;
    }

    public User(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
