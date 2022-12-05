package com.example.Clinica_Odontologica.controller;

import com.example.Clinica_Odontologica.model.Paciente;
import com.example.Clinica_Odontologica.services.PacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    private final PacienteService pacienteService;
    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }


    @PostMapping("/guardar")
    public Paciente guardarPaciente(@RequestBody Paciente paciente)  {
        System.out.println("Paciente: " + paciente.toString());
        pacienteService.crearPaciente(paciente);
        return paciente;
    }
    @GetMapping("/buscar/{id}")
    public Paciente buscarPaciente(@PathVariable Long id)  {
        return pacienteService.buscarPaciente(id);
    }

}
