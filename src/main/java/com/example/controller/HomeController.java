package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.model.Book;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Reza-PC on 1/15/2017.
 */
@Controller
@RequestMapping(value = "/Home")
public class HomeController {
    @RequestMapping(value = "")
    public String getHome(Model model){
         List<Book> li = new ArrayList<Book>();
         for(Integer i =0 ;i<9;i++) {
             Book book = new Book("reza" + i.toString(), i.toString());
             li.add(book);
         }
         model.addAttribute("books",li);
        return "Home";
    }
    @RequestMapping(value = "/{num}")
    public String page(@PathVariable("num")Long num ,Model model ){
       return "Home";
    }

}
