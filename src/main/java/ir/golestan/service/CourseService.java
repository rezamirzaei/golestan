package ir.golestan.service;

import ir.golestan.dao.CourseDAO;
import ir.golestan.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Reza-PC on 5/28/2017.
 */
@Service
public class CourseService {
    @Autowired
    ThisTerm thisTerm;
    @Autowired
    CourseDAO courseDAO;
    @Autowired
    TermService termService;
    @Autowired
    TeacherService teacherService;
    @Transactional
    public Course loadById(Long id) {
        return courseDAO.getById(id);
    }

    @Transactional
    public List<Course> loadAll() {
        return courseDAO.getAll();
    }

    @Transactional
    public void update(Long id, Long code, Term term, Teacher teacher, List<CourseTimeInweak> presentationTime, List<CourseTimeInweak> TATime, String name, String examTime, List<Course> prerequisiteCourses, int type, int group) {
        Course course = new Course(code, term, teacher, presentationTime, TATime, name, examTime, prerequisiteCourses, type, group);
        course.setId(id);
        courseDAO.update(course);
    }
    public void update(Course course){
        courseDAO.update(course);
    }

    @Transactional
    public void create(Long code, Long termCode, String teacherUsername , String name, String examTime, int type, int group) {
        Term term = termService.load(termCode);
        Teacher teacher = teacherService.load(teacherUsername);
        Course course = new Course(code, term, teacher, name, examTime, type, group);
        courseDAO.create(course);
    }
    @Transactional
    public List<User> loadUser(Long code){
       Course course = courseDAO.load(code);
        return loadUser(course);
    }
    @Transactional
    public Course load(Long code){
       return courseDAO.load(code);
    }
    @Transactional
    public List<User> loadUser(Course course){
        return course.getStudents();
    }
    @Transactional
    public List<Course> getThisTermCourse(){
        List<Course> courses = loadAll();
        List<Course> courseList = new ArrayList<Course>();
        for(Course course:courses){
            if(course.getTerm().getCode()==thisTerm.getTerm().getCode()){
                courseList.add(course);
            }
        }
        return courseList;
    }
    @Transactional
    public List<Course> getCoursByTerm(Long code){
        List<Course> courses = loadAll();
        List<Course> courseList = new ArrayList<Course>();
        Term term =termService.load(code);
        for(Course course:courses){
            if(course.getTerm().getCode()==term.getCode()){
                courseList.add(course);
            }
        }
        return courseList;
    }




}
