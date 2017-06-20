package ir.golestan.controller;

/**
 * Created by Erfan Baharvand on 6/19/2017.
 */

import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class MainControler {
    @Autowired
    HttpSession httpSession;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String mainPage(Model model) {
        return "index";
    }

}
