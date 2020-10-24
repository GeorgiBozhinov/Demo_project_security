package com.example.Demo.web.controllers;

import com.example.Demo.service.models.UserServiceModel;
import com.example.Demo.service.services.UserService;
import com.example.Demo.web.models.UserRegisterModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    private String register(){
        return "register";
    }

    @PostMapping("/register")
    private String register(@ModelAttribute UserRegisterModel model){
        if(!model.getPassword().equals(model.getConfirmPassword())){
            return "register";
        }

        this.userService.register(this.modelMapper.map(model, UserServiceModel.class));
        return "redirect:/home";
    }

    @GetMapping("/login")
    private String login(){
        return "login";
    }
}
