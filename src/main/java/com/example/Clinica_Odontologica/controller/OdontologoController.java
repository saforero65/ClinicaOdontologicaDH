package com.example.Clinica_Odontologica.controller;

import com.example.Clinica_Odontologica.dao.impl.OdontologoDaoH2;
import com.example.Clinica_Odontologica.model.Odontologo;
import com.example.Clinica_Odontologica.services.OdontologoService;
import com.example.Clinica_Odontologica.services.impl.OdontologoServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/odontologo")
public class OdontologoController {
    private final OdontologoService odontologoService= new OdontologoServiceImpl( new OdontologoDaoH2());
    //private final OdontologoService odontologoService;
    @GetMapping("/prueba")
    public String prueba(){
        return "Hola";
    }
    @GetMapping("/buscar/{id}")
        public Odontologo buscarOdotologo(@PathVariable("id") Long id ) {
        Odontologo odontologo = odontologoService.obtenerOdontologo(id);
    return odontologo;
    }
    @PostMapping("/guardar")
    public void guardarOdontologo(@RequestBody Odontologo odontologo)  {
        odontologoService.guardarOdontologo(odontologo);
    }
}
