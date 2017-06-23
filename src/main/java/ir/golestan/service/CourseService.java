package ir.golestan.service;

import ir.golestan.dao.CourseDAO;
import ir.golestan.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Reza-PC on 5/28/2017.
 */
@Service
public class CourseService {
    @Autowired
    CourseDAO courseDAO;

    @Transactional
    public Course loadById(Long id) {
        return courseDAO.getById(id);
    }

    @Transactional
    public List loadAll() {
        return courseDAO.getAll();
    }

    @Transactional
    public void update(Long id, Long code, Term term, Teacher teacher, List<CourseTimeInweak> presentationTime, List<CourseTimeInweak> TATime, String name, Date examTime, List<Course> prerequisiteCourses, int type, int group) {
        Course course = new Course(code, term, teacher, presentationTime, TATime, name, examTime, prerequisiteCourses, type, group);
        course.setId(id);
        courseDAO.update(course);
    }

    @Transactional
    public void create(Long code, Term term, Teacher teacher, List<CourseTimeInweak> presentationTime, List<CourseTimeInweak> TATime, String name, Date examTime, List<Course> prerequisiteCourses, int type, int group) {
        Course course = new Course(code, term, teacher, presentationTime, TATime, name, examTime, prerequisiteCourses, type, group);
        courseDAO.create(course);
    }
    @Transactional
    public List<User> loadUser(Long code){
       Course course = courseDAO.load(code);
        return course.getStudents();
    }





}
