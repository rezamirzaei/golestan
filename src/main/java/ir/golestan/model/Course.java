package ir.golestan.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Reza-PC on 5/28/2017.
 */
@Entity
public class Course {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    Long Code;

    @ManyToOne
    Term term;

    @ManyToOne
    User teacher;

    @OneToMany
    List<CourseTimeInweak> presentationTime;

    @OneToMany
    List<CourseTimeInweak> TATime;
    @Column
    String name;
    @Column
    Date examTime;
    @ManyToMany
    List<Course> prerequisiteCourses;
    @Column
    int type;
    @Column
    int group;

    public Course() {

    }

    public Course(Long code, Term term, User teacher, List<CourseTimeInweak> presentationTime, List<CourseTimeInweak> TATime, String name, Date examTime, List<Course> prerequisiteCourses, int type, int group) {
        Code = code;
        this.term = term;
        this.teacher = teacher;
        this.presentationTime = presentationTime;
        this.TATime = TATime;
        this.name = name;
        this.examTime = examTime;
        this.prerequisiteCourses = prerequisiteCourses;
        this.type = type;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCode() {
        return Code;
    }

    public void setCode(Long code) {
        Code = code;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public List<CourseTimeInweak> getPresentationTime() {
        return presentationTime;
    }

    public void setPresentationTime(List<CourseTimeInweak> presentationTime) {
        this.presentationTime = presentationTime;
    }

    public List<CourseTimeInweak> getTATime() {
        return TATime;
    }

    public void setTATime(List<CourseTimeInweak> TATime) {
        this.TATime = TATime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExamTime() {
        return examTime;
    }

    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }

    public List<Course> getPrerequisiteCourses() {
        return prerequisiteCourses;
    }

    public void setPrerequisiteCourses(List<Course> prerequisiteCourses) {
        this.prerequisiteCourses = prerequisiteCourses;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public void addCourseTime(CourseTimeInweak courseTimeInweak) {
        this.presentationTime.add(courseTimeInweak);
    }

    public void addTATime(CourseTimeInweak courseTimeInweak) {
        this.TATime.add(courseTimeInweak);
    }
}

