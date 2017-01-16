package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by Reza-PC on 1/15/2017.
 */
@Controller
@RequestMapping(value = "/book")
public class BookController {

    @RequestMapping(value = "/id")
    public String getBook(Model model){
     return "bookDetail";
    }

}
