package com.example.Clinica_Odontologica.controller;

import com.example.Clinica_Odontologica.exception.ResourceNotFoundException;
import com.example.Clinica_Odontologica.model.Turno;
import com.example.Clinica_Odontologica.services.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@RestController
@RequestMapping("/turno")
public class TurnoController {
    @Autowired
    private TurnoService turnoService;

    @PostMapping("/crearTurno")
    public ResponseEntity<Turno> crearTurno(@RequestBody Turno turno) throws ResourceNotFoundException {
        Turno turnoResponse=turnoService.crearTurno(turno);

        return ResponseEntity.ok().body(turnoResponse);
    }
    @GetMapping("/buscarTurno/{id}")
    public ResponseEntity<Turno> buscarTurno(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Turno turnoResponse=turnoService.buscarTurno(id);
        return ResponseEntity.ok().body(turnoResponse);
    }
    @GetMapping("/buscarTodosTurnos")
    public ResponseEntity<Iterable<Turno>> buscarTodosTurnos() throws ResourceNotFoundException {
        Iterable<Turno> turnoResponse=turnoService.buscarTodosTurnos();
        return ResponseEntity.ok().body(turnoResponse);
    }
}
