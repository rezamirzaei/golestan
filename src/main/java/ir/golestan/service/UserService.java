package ir.golestan.service;

import ir.golestan.dao.UserDAO;
import ir.golestan.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by Reza-PC on 5/28/2017.
 */
@Service
public class UserService {
    @Autowired
    HttpSession httpSession;
    @Autowired
    private UserDAO userDAO;

    @Transactional
    public boolean login(String username, String password) {
        User user = userDAO.getById(username);
        if (user != null && user.getPassword().compareTo(password) == 0) {
            System.out.println(user.getPassword());
            httpSession.setAttribute("username", user.getUsername());
            httpSession.setAttribute("name", user.getName());
            httpSession.setAttribute("family", user.getFamily());
            httpSession.setAttribute("rule", user.getRole());
            return true;
        }
        return false;
    }

    @Transactional
    public boolean signUp(String name, String family, String username, String password, Date birthDay, String fatherName, Long nationalNumber, Long postalCode, String address) {
        String rule = "user";
        User user = new User(name, family, username, password, rule, birthDay, fatherName, nationalNumber, postalCode, address);
        boolean valid = userDAO.validNewUser(username);
        if (valid) {
            userDAO.create(user);
            httpSession.setAttribute("username", user.getUsername());
            httpSession.setAttribute("name", name);
            httpSession.setAttribute("family", family);
            httpSession.setAttribute("rule", user.getRole());
            return true;
        }
        return false;
    }

    @Transactional
    public boolean changeInfo(String name, String family, String oldPassword, String newPassword, String roles, Date birthDay, String fatherName, Long nationalNumber, Long postalCode, String address) {
        User user = userDAO.login((String) httpSession.getAttribute("username"), oldPassword);
        if (user != null) {
            user = new User(name, family, (String) httpSession.getAttribute("username"), newPassword, user.getRole(), birthDay, fatherName, nationalNumber, postalCode, address);
            userDAO.update(user);
            return true;
        }
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
}
