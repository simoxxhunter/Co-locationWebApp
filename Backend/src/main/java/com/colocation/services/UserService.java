package com.colocation.services;

import com.colocation.models.ProfileModel;

public interface UserService {
    ProfileModel getProfile(Long userId);
}
