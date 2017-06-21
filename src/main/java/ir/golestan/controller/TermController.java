package ir.golestan.controller;

import ir.golestan.model.Term;
import ir.golestan.service.TermService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Reza-PC on 6/21/2017.
 */
@Controller
public class TermController {
    @Autowired
    HttpSession httpSession;
    @Autowired
    TermService termService;
    @RequestMapping(value = "/maketerm",method = RequestMethod.GET)
    public String mainTerm(Model model){
        if(httpSession.getAttribute("username")!=null&&((String)httpSession.getAttribute("rule")).compareTo("admin")==0){
            List<Term> terms = termService.loadAll();
            model.addAttribute("terms",terms);
            return "makeTerm";
        }
        return "home";
    }
    @RequestMapping(value = "/maketerm" ,method = RequestMethod.POST)
    public String makeTerm(@RequestParam("code")Long code,@RequestParam("year")int year,@RequestParam("season")int season,Model model){
        if(httpSession.getAttribute("username")!=null&&((String)httpSession.getAttribute("rule")).compareTo("admin")==0){
           Term term = new Term();
            term.setCode(code);
            term.setSeason(season);
            term.setYear(year);
            termService.create(term);
            List<Term> terms = termService.loadAll();
            model.addAttribute("terms",terms);
            return "makeTerm";
        }
        return "home";
    }

}
