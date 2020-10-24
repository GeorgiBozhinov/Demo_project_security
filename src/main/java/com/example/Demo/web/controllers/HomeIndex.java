package com.example.Demo.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeIndex {

    @GetMapping("/")
    public String index(){
        return "index";
    }

}
