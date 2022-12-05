package com.example.Clinica_Odontologica.controller;

import com.example.Clinica_Odontologica.services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }
    @GetMapping("/user")
    public String user(){
        return "user";
    }
}
