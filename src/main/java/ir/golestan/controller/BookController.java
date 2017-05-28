package ir.golestan.controller;

import ir.golestan.model.Book;
import ir.golestan.service.BookService;
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
    @Autowired
    HttpSession httpSession;
    @Autowired
    BookService bookService;
    @RequestMapping(value = "/{id}")
    public String getBook(@PathVariable("id")int id,Model model){
       Book book = bookService.Load(id);
        model.addAttribute("book",book);
        return "bookDetail";
    }

}
