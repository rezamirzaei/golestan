package ir.golestan.controller;


import ir.golestan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by Reza-PC on 5/28/2017.
 */
@Controller
@RequestMapping(value = "")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    HttpSession httpSession;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String SignUp(Model model) {
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String SignUp(@RequestParam("name") String name, @RequestParam("familyName") String family, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("fatherName") String fatherName, @RequestParam("nationalNumber") Long nationalNumber, @RequestParam("postalCode") Long postalCode, @RequestParam("address") String address, Model model) {
        if (userService.signUp(name, family, username, password, new Date(), fatherName, nationalNumber, postalCode, address)) {
            return "home";
        }
        return "signup";
    }

    @RequestMapping(value = "/logout")
    public String logout() {
        httpSession.removeAttribute("username");
        httpSession.removeAttribute("name");
        httpSession.removeAttribute("family");
        httpSession.removeAttribute("rule");
        return "login";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        if (userService.login(username, password)) {
            return "home";
        }
        return "login";
    }

    @RequestMapping(value = "/changeInfo", method = RequestMethod.GET)
    public String changeInfo() {
        return "changeInfo";
    }

    @RequestMapping(value = "/changeInfo", method = RequestMethod.POST)
    public String changeInfo(@RequestParam("name") String name, @RequestParam("familyName") String family, @RequestParam("username") String username, @RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword, @RequestParam("fatherName") String fatherName, @RequestParam("nationalNumber") Long nationalNumber, @RequestParam("postalCode") Long postalCode, @RequestParam("address") String address, Model model) {
        if (userService.changeInfo(name, family, username, oldPassword, newPassword, new Date(), fatherName, nationalNumber, postalCode, address)) {
            return "home";
        }
        return "changeInfo";
    }


}
