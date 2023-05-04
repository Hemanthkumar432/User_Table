package com.user.table.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.table.model.User;
import com.user.table.repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public List<User> saveUserAll(List<User> users) {
        return userRepo.saveAll(users);
    }

    public List<User> getall() {
        return userRepo.findAll();
    }

}
