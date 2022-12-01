package com.example.Clinica_Odontologica.controller;

import com.example.Clinica_Odontologica.dao.impl.OdontologoDaoH2;
import com.example.Clinica_Odontologica.services.OdontologoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/odontologo")
public class OdontologoController {
    private final OdontologoService odontologoService= new OdontologoService( new OdontologoDaoH2());

    public OdontologoController() {
    }

    @GetMapping("/prueba")
    public String prueba(){
        return "Hola";
    }
}
