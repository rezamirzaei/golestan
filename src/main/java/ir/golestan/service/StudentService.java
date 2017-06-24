package ir.golestan.service;

import ir.golestan.dao.UserDAO;
import ir.golestan.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Reza-PC on 6/24/2017.
 */
@Service
public class StudentService {

    @Autowired
    ThisTerm thisTerm;
    @Autowired
    HttpSession httpSession;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    TermService termService;
    @Autowired
    CourseService courseService;

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
    public List<Course> loadCourses(String username){
        return load(username).getCourses();
    }
    @Transactional
    public User load(String username){
        return userDAO.load(username);
    }
    @Transactional
    public List<Course> loadCourseByIdTerm(String username , Long code){
        Term term =  termService.load(code);
        return loadCourseByTerm(username,term);
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
    public List<Course> loadCourseInThisTerm(String username){
        return loadCourseByTerm(username,thisTerm.getTerm());
    }
    @Transactional
    public int getScore(String username,Long courseCode){
        User user =  load(username);
        Course course = courseService.load(courseCode);
        return course.getScore(username);
    }
    @Transactional
    public Score getScoreWithCourse(String username,Long courseCode){
        Course course = courseService.load(courseCode);
        return course.getScoreWithCourse(username);
    }
    @Transactional
    public List<Score> getScoreWithCourseInTerm(String username,Long termCode){

        List<Course>  courses= this.loadCourseByIdTerm(username,termCode);
        List<Score> scores = new ArrayList<Score>();
        for(Course course:courses){
          scores.add(course.getScoreWithCourse(username));
        }
        return scores;
    }
    @Transactional
    public boolean choiceCourse(String username,Long courseCode){
        List<Course> thisTermCourse =loadCourseInThisTerm(username);
        if(thisTermCourse.size()<6){
            Course course=courseService.load(courseCode);
            if(course.getTerm().getCode()==thisTerm.getTerm().getCode()){
            User user = this.load(username);
            boolean b =course.addStudent(user);
                if(b){
            courseService.update(course);
                    return true;
                }
            }
        }
        return false;
    }

}
