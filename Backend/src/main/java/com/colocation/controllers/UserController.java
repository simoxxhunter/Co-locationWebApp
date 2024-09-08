package com.colocation.controllers;

import com.colocation.models.ProfileModel;
import com.colocation.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServiceImp userService;

    @GetMapping("/profile/{userId}")
    public ProfileModel getProfile(@PathVariable Long userId) {
        return userService.getProfile(userId);
    }
}
