package ir.golestan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Reza-PC on 5/28/2017.
 */
@Entity
@Table(name = "GOL_USER")
public class User {
    @Column
    String name;
    @Column
    String family;
    @Id
    @Column(unique = true)
    String username;
    @Column
    String password;
    @Column
    String roles;
    @Column
    Date birthDay;
    @Column
    String fatherName;
    @Column
    Long nationalNumber;
    @Column
    Long postalCode;
    @Column
    String address;

    public User() {

    }

    public User(String name, String family, String username, String password, String roles, Date birthDay, String fatherName, Long nationalNumber, Long postalCode, String address) {
        this.name = name;
        this.family = family;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.birthDay = birthDay;
        this.fatherName = fatherName;
        this.nationalNumber = nationalNumber;
        this.postalCode = postalCode;
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return roles;
    }

    public void setRole(String roles) {
        this.roles = roles;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Long getNationalNumber() {
        return nationalNumber;
    }

    public void setNationalNumber(Long nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

    public Long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Long postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}



