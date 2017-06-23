package ir.golestan.controller;

/**
 * Created by Erfan Baharvand on 6/19/2017.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class MainControler {
    @Autowired
    HttpSession httpSession;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String mainPage(Model model) {
        if (httpSession.getAttribute("username") != null) {
            String CurrentRole = (String) httpSession.getAttribute("role");
            System.out.println(CurrentRole);
            if (Objects.equals(CurrentRole, "admin"))
                return "adminPanel";
            if (Objects.equals(CurrentRole, "teacher"))
                return "Home-Prof";
            else if (Objects.equals(CurrentRole, "student"))
                return "home";
        }
        return "index";
    }

}
