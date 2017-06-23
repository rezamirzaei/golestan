package ir.golestan.controller;


import ir.golestan.model.User;
import ir.golestan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
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

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminLogin(Model model) {
        if(httpSession.getAttribute("username") != null){
            List<User> users = userService.loadAll();
            model.addAttribute("users",users);
            return "adminPanel";
        }
        return "adminLogin";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String adminLogin(Model model,@RequestParam("username") String username, @RequestParam("password") String password){
        if(userService.adminLogin(username, password)){
            return "adminPanel";
        }
        return "adminLogin";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String SignUp(Model model) {
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String SignUp(@RequestParam("name") String name, @RequestParam("familyName") String family, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("fatherName") String fatherName, @RequestParam("nationalNumber") Long nationalNumber, @RequestParam("postalCode") Long postalCode, @RequestParam("address") String address, @RequestParam("birthDay") String birthDay, Model model) {
        if (userService.signUp(name, family, username, password, birthDay, fatherName, nationalNumber, postalCode, address)) {
            return "home";
        }
        return "signup";
    }

    @RequestMapping(value = "/logout")
    public String logout() {
        userService.logout();
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

    @RequestMapping(value = "/changeInfoPage", method = RequestMethod.GET)
    public String changeInfo(Model model) {
        if (httpSession.getAttribute("username") != null)
            model.addAttribute("user", userService.loadUser());
        return "changeInfo";
    }

    @RequestMapping(value = "/changeInfoSave", method = RequestMethod.POST)
    public String changeInfo(@RequestParam("name") String name, @RequestParam("familyName") String family, @RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword, @RequestParam("fatherName") String fatherName, @RequestParam("nationalNumber") Long nationalNumber, @RequestParam("postalCode") Long postalCode, @RequestParam("address") String address, @RequestParam("birthDay") String birthDay, Model model) {
        if (httpSession.getAttribute("username") != null && userService.loginForSecurity((String) httpSession.getAttribute("username"), oldPassword) && userService.changeInfo(name, family, newPassword, birthDay, fatherName, nationalNumber, postalCode, address)) {
            return "home";

        }
        return "changeInfo";
    }


}
