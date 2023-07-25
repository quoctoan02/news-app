package com.example.mobile.controllers;

import com.example.mobile.models.User;
import com.example.mobile.repostories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(ModelMap modelMap){
        return "hello world...";
    }

    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public String insertUser(@RequestParam String email, @RequestParam String password) {
        try {
            User user = new User(email, password);
            userRepository.save(user);
            return "insert user success";
        } catch(Exception e)   {
            return e.toString();
        }
    }
    @RequestMapping(value = "showAllUsers", method = RequestMethod.GET)
    public Iterable<User> showAllUsers() {
        return userRepository.findAll();
    }
}
