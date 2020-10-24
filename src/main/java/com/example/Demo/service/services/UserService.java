package com.example.Demo.service.services;

import com.example.Demo.data.model.User;
import com.example.Demo.service.models.UserServiceModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User register(UserServiceModel model);
}
