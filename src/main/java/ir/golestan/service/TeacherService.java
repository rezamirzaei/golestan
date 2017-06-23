package ir.golestan.service;

import ir.golestan.dao.TeacherDAO;
import ir.golestan.dao.TermDAO;
import ir.golestan.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Reza-PC on 6/23/2017.
 */
@Service
public class TeacherService {
    @Autowired
    ThisTerm thisTerm;
    @Autowired
    HttpSession httpSession;
    @Autowired
    TeacherDAO teacherDAO;
    @Autowired
    TermService termService;
    @Autowired
    CourseService courseService;
    public void create(String username){
        Teacher teacher = new Teacher(username,(new ArrayList<Course>()));
        teacherDAO.create(teacher);
    }
    public Teacher load(String username){
        return teacherDAO.load(username);
    }
    public List<Course> loadCourses(String username){
        return load(username).getCourses();
    }
    public List<Course> loadCourseByTerm(String username , Term term){
        List<Course> courses = loadCourses(username);
        List<Course> coursesInTerm = new ArrayList<Course>();
        for(Course course:courses){
            if(course.getTerm().getCode()==term.getCode()){
                coursesInTerm.add(course);
            }
        }
        return coursesInTerm;
    }
    public Set<Term> loadAllTerm(String username){
        Set<Term> terms = new HashSet<Term>();
        List<Course> courses = loadCourses(username);
        for(Course course:courses){
            terms.add(course.getTerm());
        }
        return terms;
    }
    public List<Course> loadCourseByIdTerm(String username , Long code){
        Term term =  termService.load(code);
        return loadCourseByTerm(username,term);
    }
    public List<Course> loadCourseInThisTerm(String username){
        return loadCourseByTerm(username,thisTerm.getTerm());
    }
    public List<User> loadStudent(String username,Long courseCode){
       List<Course> courses = loadCourses(username);
       Course course = courseService.load(courseCode);
       if(courses.contains(course)){
           return course.getStudents();
       }
       return null;
    }

}
