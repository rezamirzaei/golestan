package ir.golestan.controller;

import ir.golestan.model.Book;
import ir.golestan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by Reza-PC on 1/15/2017.
 */
@Controller
@RequestMapping(value = "")
public class HomeController {
    @Autowired
    HttpSession httpSession;
    @Autowired
    BookService bookService;

    @RequestMapping(value = "")
    public String getHome(Model model) {
        List<Book> books = bookService.loadPageEntitys(1);
        model.addAttribute("books", books);
      //  List<String>  categorys  = bookService.loadTopRecentCategory(6);
       // List<String>  writers= bookService.loadTopRecentWriter(6);
    //    model.addAttribute("categorys",categorys);
    //    model.addAttribute("writers",writers);
        return "home";
    }

    @RequestMapping(value = "/{num}")
    public String page(@PathVariable("num") int num, Model model) {
        List<Book> books = bookService.loadPageEntitys(num);
        model.addAttribute("books", books);
        model.addAttribute("currentPage", num);
        return "home";
    }
    @RequestMapping(value = "/search")
    public String search(@PathParam("name") String name,Model model ){
       Book  book=  bookService.search(name);
        model.addAttribute("book",book);
        return "bookDetail";
    }
}
