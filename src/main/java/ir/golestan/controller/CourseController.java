package ir.golestan.controller;

import ir.golestan.model.*;
import ir.golestan.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by Reza-PC on 5/28/2017.
 */
@Controller
public class CourseController {
    @Autowired
    CourseService courseService;
    @Autowired
    HttpSession httpSession;

    @RequestMapping(value = "course/{id}/change", method = RequestMethod.GET)
    public String changeCourse(@PathParam("id") Long id, Model model) {
        if (httpSession.getAttribute("role") != null && ((String) httpSession.getAttribute("role")).compareTo("admin") == 0) {
            Course course = courseService.loadById(id);
            if (course != null) {
                model.addAttribute(course);
                return "courseRegisteringEdit";
            }
        }
        return "home";
    }

    @RequestMapping(value = "course/{id}/change", method = RequestMethod.POST)
    public String changeCourse(@PathVariable("id") Long id, Long code, Term term, Teacher teacher, List<CourseTimeInweak> presentationTime, List<CourseTimeInweak> TATime, String name, String examTime, List<Course> prerequisiteCourses, int type, int group, Model model) {
        if (httpSession.getAttribute("role") != null && ((String) httpSession.getAttribute("role")).compareTo("admin") == 0)
            courseService.update(id, code, term, teacher, presentationTime, TATime, name, examTime, prerequisiteCourses, type, group);
        return "home";
    }

    @RequestMapping(value = "course/{termCode}/create", method = RequestMethod.POST)
    public String create(@PathVariable("termCode")Long termCode ,@RequestParam("code")Long code,@RequestParam("teacherUsername") String  teacherUsername,@RequestParam("name") String name,@RequestParam("examDate") String examTime,@RequestParam(value = "type",defaultValue="0") int type,@RequestParam(value = "group" ,defaultValue = "0") int group, Model model) {
        if (httpSession.getAttribute("rule") != null && ((String) httpSession.getAttribute("role")).compareTo("admin") == 0)
            courseService.create(code, termCode, teacherUsername, name, examTime, type, group);
        return "home";
    }
}
