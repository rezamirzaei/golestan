package ir.golestan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Reza-PC on 6/22/2017.
 */
@Entity
public class Teacher {
    @Id
    @Column
    String username ;
    @OneToMany(mappedBy = "teacher")
    List<Course> courses;

    public Teacher(String username, List<Course> courses) {
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
    public void addCourse(Course course){
        courses.add(course);
    }

}
