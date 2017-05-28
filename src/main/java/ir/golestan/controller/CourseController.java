package ir.golestan.controller;

import ir.golestan.model.Course;
import ir.golestan.service.CourseService;
import ir.golestan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

/**
 * Created by Reza-PC on 5/28/2017.
 */
@Controller
public class CourseController {
    @Autowired
    CourseService courseService;
    @Autowired
    HttpSession httpSession ;

    @RequestMapping(value = "course/{id}/change",method = RequestMethod.GET)
    public String changeCourse(@PathParam("id")Long id,Model model){
       Course course = courseService.loadById(id);
        if(course!=null){
            model.addAttribute(course);
            return "courseRegisteringEdit";
        }
        return "home";
    }
    @RequestMapping(value = "course/{id}/change",method = RequestMethod.POST)
    public String changeCourse(@PathParam("")String s,@PathParam("id")Long id,Model model){
        Course course = courseService.update();
        if(course!=null){
            model.addAttribute(course);
            return "courseRegisteringEdit";
        }
        return "home";
    }

}
