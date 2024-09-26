package com.colocation.controllers;

import com.colocation.models.ProfileModel;
import com.colocation.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")

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
