package ir.golestan.service;

import ir.golestan.dao.TeacherDAO;
import ir.golestan.dao.UserDAO;
import ir.golestan.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by Reza-PC on 5/28/2017.
 */
@Service
public class UserService {
    @Autowired
    ThisTerm thisTerm;
    @Autowired
    HttpSession httpSession;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    TermService termService;
    @Autowired
    CourseService courseService;
    @Autowired
    TeacherService teacherService ;
    @Transactional
    public boolean login(String username, String password) {
        User user = userDAO.getById(username);
        if (user != null && user.getPassword().compareTo(password) == 0) {
            System.out.println(user.getPassword());
            httpSession.setAttribute("username", user.getUsername());
            httpSession.setAttribute("name", user.getName());
            httpSession.setAttribute("family", user.getFamily());
            httpSession.setAttribute("role", user.getRole());
            return true;
        }
        return false;
    }

    @Transactional
    public boolean signUp(String role ,String name, String family, String username, String password, String birthDay, String fatherName, Long nationalNumber, Long postalCode, String address ,boolean inAdmin) {
        User user = new User(name, family, username, password, role, birthDay, fatherName, nationalNumber, postalCode, address);
        boolean valid = userDAO.validNewUser(username);
        if (valid) {
            userDAO.create(user);
            if (Objects.equals(role, "teacher")){
                teacherService.create(username);
            }
            if (!inAdmin){
                httpSession.setAttribute("username", user.getUsername());
                httpSession.setAttribute("name", name);
                httpSession.setAttribute("family", family);
                httpSession.setAttribute("role", user.getRole());
            }
            return true;
        }
        return false;
    }

    @Transactional
    public boolean changeInfo(String name, String family, String newPassword, String birthDay, String fatherName, Long nationalNumber, Long postalCode, String address, String role) {
        if (httpSession.getAttribute("username") != null) {
            User user = new User(name, family, (String) httpSession.getAttribute("username"), newPassword, role, birthDay, fatherName, nationalNumber, postalCode, address);
            userDAO.update(user);
            return true;
        } else
            return false;

    }

    @Transactional
    public User loadUser() {
        return (User) userDAO.load((String) httpSession.getAttribute("username"));
    }

    @Transactional
    public void logout() {
        httpSession.removeAttribute("username");
        httpSession.removeAttribute("name");
        httpSession.removeAttribute("family");
        httpSession.removeAttribute("role");

    }

    @Transactional
    public boolean loginForSecurity(String username, String password) {
        User user = userDAO.login(username, password);
        if (user == null) {
            return false;
        }
        return true;

    }

    @Transactional
    public List<User> loadAll() {
        return userDAO.loadAll();
    }




}
