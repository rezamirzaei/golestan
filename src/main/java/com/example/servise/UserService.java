package com.example.servise;

import com.example.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Reza-PC on 1/16/2017.
 */
@Service
public class UserService {
    @Autowired
private UserDAO userDAO;

}
