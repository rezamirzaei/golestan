package ir.golestan.model;

import javax.persistence.*;
import java.util.*;

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

    @Column
    int capacity;

    @ManyToOne
    Teacher teacher;

    @Column
    String status;

    @OneToMany(mappedBy = "course")
    List<Score> studentScore;
    @ManyToMany
    List<User> students;

    @OneToMany
    List<CourseTimeInweak> presentationTime;

    @OneToMany
    List<CourseTimeInweak> TATime;
    @Column
    String name;
    @Column
    String examTime;
    @ManyToMany
    List<Course> prerequisiteCourses;
    @Column
    int type;
    @Column
    int group;

    public Course() {

    }

    public Course(Long code, Term term, Teacher teacher, String name, String examTime, int type, int group) {
        Code = code;
        this.term = term;
        this.capacity = capacity;
        this.teacher = teacher;
        this.name = name;
        this.examTime = examTime;
        this.type = type;
        this.group = group;
        this.presentationTime = new ArrayList<CourseTimeInweak>();
        this.TATime =  new ArrayList<CourseTimeInweak>();
        this.status = "not announced";
        this.students = new ArrayList<User>();
        this.studentScore = new ArrayList<Score>();
        this.capacity = 30;
    }

    public Course(Long code, Term term, Teacher teacher, List<CourseTimeInweak> presentationTime, List<CourseTimeInweak> TATime, String name, String examTime, List<Course> prerequisiteCourses, int type, int group) {
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
        this.status = "not announced";
        this.students = new ArrayList<User>();
        this.studentScore = new ArrayList<Score>();
        this.capacity = 30;
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
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

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<User> getStudents() {
        return students;
    }

    public void setStudents(List<User> students) {
        this.students = students;
    }

    public boolean addStudent(User student)
    {   if(capacity>=students.size()){
        this.students.add(student);
        this.studentScore.add(new Score(student.getUsername(),0));
        return true;
        }
        return false;
    }
    public void deleteStudent(User student){
        this.students.remove(student);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setScore(String username,int score){
        for(int i =0;i<studentScore.size();i++){
           Score sScore = studentScore.get(i);
            if(sScore.getUsername()==username){
                studentScore.remove(i);
                sScore.setScore(score);
                studentScore.add(sScore);
                return;
            }
        }
    }


    public int getScore(String username){
        for(int i =0;i<studentScore.size();i++){
            Score sScore = studentScore.get(i);
            if(sScore.getUsername()==username){
                return sScore.getScore();
            }
        }
        return 0;
    }
    public Score getScoreWithCourse(String username){
        for(int i =0;i<studentScore.size();i++){
            Score sScore = studentScore.get(i);
            if(sScore.getUsername()==username){
                return sScore;
            }
        }
        return null;
    }


    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Score> getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(List<Score> studentScore) {
        this.studentScore = studentScore;
    }

}

