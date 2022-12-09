package com.example.Clinica_Odontologica.controller;

import com.example.Clinica_Odontologica.exception.ResourceNotFoundException;
import com.example.Clinica_Odontologica.model.Turno;
import com.example.Clinica_Odontologica.services.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
@RequestMapping("/turno")
public class TurnoController {
    @Autowired
    private TurnoService turnoService;

    @PostMapping("/crearTurno")
    public ResponseEntity<Turno> crearTurno(@RequestBody Turno turno) throws ResourceNotFoundException {
        turnoService.crearTurno(turno);


        return ResponseEntity.ok().body(turno);
    }
}
