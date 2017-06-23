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
import java.util.Objects;

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

    @RequestMapping(value = "/changeInfoPanel", method = RequestMethod.GET)
    public String changeInfoAdminPanel(Model model) {
        if(httpSession.getAttribute("username") != null){
            List<User> users = userService.loadAll();
            model.addAttribute("users",users);
            return "changeUserInfo-AdminPanel";
        }
        return "login";
    }

    @RequestMapping(value = "/changeInfoPanel", method = RequestMethod.POST)
    public String changeInfoAdminPanel(@RequestParam("role") String role ,@RequestParam("name") String name, @RequestParam("familyName") String family, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("fatherName") String fatherName, @RequestParam("nationalNumber") Long nationalNumber, @RequestParam("postalCode") Long postalCode, @RequestParam("address") String address, @RequestParam("birthDay") String birthDay,Model model) {
        if (httpSession.getAttribute("username") != null  && userService.changeInfo(name, family, password, birthDay, fatherName, nationalNumber, postalCode, address,role)) {
            return "adminPanel";
        }
        return "login";
    }

    @RequestMapping(value = "/createNewUserInAdminPanel", method = RequestMethod.GET)
    public String createNewUserAdminPanel(Model model){
        if(httpSession.getAttribute("username") != null){
            return "createNewUser-adminPanel";
        }
        return "login";
    }

    @RequestMapping(value = "/createNewUserInAdminPanel", method = RequestMethod.POST)
    public String createNewUserAdminPanel(@RequestParam("role") String role ,@RequestParam("name") String name, @RequestParam("familyName") String family, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("fatherName") String fatherName, @RequestParam("nationalNumber") Long nationalNumber, @RequestParam("postalCode") Long postalCode, @RequestParam("address") String address, @RequestParam("birthDay") String birthDay,Model model){
        if((httpSession.getAttribute("username") != null)){
            if (userService.signUp(role ,name, family, username, password, birthDay, fatherName, nationalNumber, postalCode, address ,true)) {
                return "adminPanel";
            }
            return "createNewUser-adminPanel";
        }
        return "login";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String SignUp(Model model) {
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String SignUp(@RequestParam("name") String name, @RequestParam("familyName") String family, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("fatherName") String fatherName, @RequestParam("nationalNumber") Long nationalNumber, @RequestParam("postalCode") Long postalCode, @RequestParam("address") String address, @RequestParam("birthDay") String birthDay, Model model) {
        String role = "student";
        if (userService.signUp(role ,name, family, username, password, birthDay, fatherName, nationalNumber, postalCode, address ,false)) {
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
            String CurrentRole = (String) httpSession.getAttribute("role");
            if (Objects.equals(CurrentRole, "admin"))
                return "adminPanel";
            else if(Objects.equals(CurrentRole, "teacher"))
                return "Home-Prof";
            else if(Objects.equals(CurrentRole, "student"))
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
        if (httpSession.getAttribute("username") != null && userService.loginForSecurity((String) httpSession.getAttribute("username"), oldPassword) && userService.changeInfo(name, family, newPassword, birthDay, fatherName, nationalNumber, postalCode, address,(String) httpSession.getAttribute("role"))) {
            return "home";
        }
        return "changeInfo";
    }


}
