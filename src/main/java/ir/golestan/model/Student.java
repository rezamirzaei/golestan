package ir.golestan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Created by Reza-PC on 6/22/2017.
 */
@Entity
public class Student {
    @Id
    @Column
    String username;
    @ManyToMany
    List<Course> courses;

    public Student(){

    }

    public Student(String username,List courses){
        this.username = username;
        this.courses = courses;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
