package com.example.Clinica_Odontologica.controller;

import com.example.Clinica_Odontologica.model.Usuario;
import com.example.Clinica_Odontologica.services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Usuario usuario) {
        userService.registrarUsuario(usuario);
        return ResponseEntity.ok("User registered successfully");
    }


}
