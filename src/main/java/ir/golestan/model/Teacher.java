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
}
