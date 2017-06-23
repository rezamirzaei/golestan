package ir.golestan.service;

import ir.golestan.dao.TeacherDAO;
import ir.golestan.dao.TermDAO;
import ir.golestan.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.*;

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
    @Transactional
    public void create(String username){
        Teacher teacher = new Teacher(username,(new ArrayList<Course>()));
        teacherDAO.create(teacher);
    }
    @Transactional
    public Teacher load(String username){
        return teacherDAO.load(username);
    }
    @Transactional
    public List<Course> loadCourses(String username){
        return load(username).getCourses();
    }
    @Transactional
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
    @Transactional
    public Set<Term> loadAllTerm(String username){
        Set<Term> terms = new HashSet<Term>();
        List<Course> courses = loadCourses(username);
        for(Course course:courses){
            terms.add(course.getTerm());
        }
        return terms;
    }
    @Transactional
    public List<Course> loadCourseByIdTerm(String username , Long code){
        Term term =  termService.load(code);
        return loadCourseByTerm(username,term);
    }
    @Transactional
    public List<Course> loadCourseInThisTerm(String username){
        return loadCourseByTerm(username,thisTerm.getTerm());
    }
    @Transactional
    public List<User> loadStudent(String username,Long courseCode){
       List<Course> courses = loadCourses(username);
       Course course = courseService.load(courseCode);
       if(courses.contains(course)){
           return course.getStudents();
       }
       return null;
    }
    @Transactional
    public void setScore(String username,Long courseCode,Map score){
        Teacher teacher =  load(username);
        List<Course>  courses=teacher.getCourses();
        Course course = courseService.load(courseCode);
        if(courses.contains(course)){
            for(User u:course.getStudents()){
                if(score.containsKey(u.getUsername()))
                course.setScore(u.getUsername(),(Integer)score.get(u.getUsername()));
            }
        }
        courseService.update(course);
    }
    @Transactional
    public void setScore(String username,Long courseCode,String studentUsername,int score){
        Teacher teacher =  load(username);
        List<Course>  courses=teacher.getCourses();
        Course course = courseService.load(courseCode);
        if(courses.contains(course)){
            course.setScore(studentUsername,score);
        }
    }
    @Transactional
    public List<Score> loadStudentScore(String username,Long courseCode){
        List<Course> courses = loadCourses(username);
        Course course = courseService.load(courseCode);
        if(courses.contains(course)){
            return course.getStudentScore();
        }
        return null;
    }
}
