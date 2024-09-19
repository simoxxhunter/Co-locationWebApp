package com.colocation.services;

import com.colocation.models.ProfileModel;
import com.colocation.models.UserModel;
import com.colocation.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepo userRepository;

    @Override
    public ProfileModel getProfile(Long userId) {
        return null;
    }

//    public ProfileModel getProfile(Long userId) {
//        UserModel user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        if (user.getProfiles() != null && !user.getProfiles().isEmpty()) {
//            return user.getProfiles().iterator().next();
//        } else {
//            throw new RuntimeException("Profile not found");
//        }
//    }
}
