package ir.golestan.controller;

import ir.golestan.model.Course;
import ir.golestan.model.Score;
import ir.golestan.service.CourseService;
import ir.golestan.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Reza-PC on 6/24/2017.
 */
@Controller
public class TeacherController {
    @Autowired
    HttpSession httpSession;
    @Autowired
    TeacherService teacherService;
    @Autowired
    CourseService courseService;
    @RequestMapping(value = "/terms")
    public String getTerms(Model model){
        if(httpSession.getAttribute("rule")!=null&&((String)httpSession.getAttribute("rule")).compareTo("teacher")==0){
            model.addAttribute("terms",teacherService.loadAllTerm((String)httpSession.getAttribute("username"))) ;
            return null;
        }
        return "Home";
    }
    @RequestMapping(value = "/term/{termCode}")
    public String getCourseInTerm(@PathVariable("termCode")Long termCode,Model model){
        if(httpSession.getAttribute("rule")!=null&&((String)httpSession.getAttribute("rule")).compareTo("teacher")==0){
            List<Course> courses = teacherService.loadCourseByIdTerm((String)httpSession.getAttribute("username"),termCode);
            model.addAttribute("courses",courses) ;
            return null;
        }
        return "Home";
    }
    @RequestMapping(value = "term/{termCode}/{courseCode}",method = RequestMethod.GET)
    public String getStudentIncourseInterm(@PathVariable("termCode")Long termCode,@PathVariable("courseCode")Long courseCode,Model model){
        if(httpSession.getAttribute("rule")!=null&&((String)httpSession.getAttribute("rule")).compareTo("teacher")==0){
            List<Score> studentScore = teacherService.loadStudentScore((String)httpSession.getAttribute("username"),courseCode);
            model.addAttribute("students",studentScore);
            return null;
        }
        return "Home";
    }
    @RequestMapping(value = "term/{termCode}/{courseCode}",method = RequestMethod.POST)
    public String setScore(@RequestParam("StudentUsername") String username,@RequestParam("score")int score,@PathVariable("termCode")Long termCode,@PathVariable("courseCode")Long courseCode, Model model){
        if(httpSession.getAttribute("rule")!=null&&((String)httpSession.getAttribute("rule")).compareTo("teacher")==0){
            teacherService.setScore((String)httpSession.getAttribute("username"),courseCode,username,score);
            List<Score> studentScore = teacherService.loadStudentScore((String)httpSession.getAttribute("username"),courseCode);
            model.addAttribute("students",studentScore);
            return null;
        }
        return "Home";
    }
}
