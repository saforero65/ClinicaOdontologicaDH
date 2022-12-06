package com.example.Clinica_Odontologica.controller;

import com.example.Clinica_Odontologica.model.ResponseJson;
import com.example.Clinica_Odontologica.model.Usuario;
import com.example.Clinica_Odontologica.services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());
    @Autowired
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")

    public ResponseEntity<?> registerUser(@RequestBody Usuario usuario) {
        LOGGER.info("Usuario: " + usuario.getNombre() + " " + usuario.getApellido());
        LOGGER.info("Usuario: " + usuario.getEmail() + " " + usuario.getPassword());

        userService.registrarUsuario(usuario);
        ResponseJson responseJson = new ResponseJson("Usuario registrado con exito", usuario);
        return ResponseEntity.status(201).body(responseJson);
    }


}
