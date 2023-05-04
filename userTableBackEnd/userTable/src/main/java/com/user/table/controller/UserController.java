package com.user.table.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.table.model.User;
import com.user.table.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/adduser")
    public User saveUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @PostMapping("/addlist")
    public List<User> saveUsers(@RequestBody List<User> users) {
        return service.saveUserAll(users);
    }


    @GetMapping("/users")
    public List<User> getUsers() {
        return service.getall();
    }


}
