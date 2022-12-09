package com.example.Clinica_Odontologica.controller;

import com.example.Clinica_Odontologica.exception.ResourceNotFoundException;
import com.example.Clinica_Odontologica.model.Paciente;
import com.example.Clinica_Odontologica.services.PacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
@CrossOrigin(origins = "*")
public class PacienteController {
    private final PacienteService pacienteService;
    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }


    @PostMapping("/guardar")
    public Paciente guardarPaciente(@RequestBody Paciente paciente) throws ResourceNotFoundException {
        System.out.println("Paciente: " + paciente.toString());
        pacienteService.crearPaciente(paciente);
        return paciente;
    }
    @GetMapping("/buscar/{id}")
    public Paciente buscarPaciente(@PathVariable Long id) throws ResourceNotFoundException {
        return pacienteService.buscarPaciente(id);
    }
    @GetMapping("/buscarTodos")
    public Iterable<Paciente> buscarTodosPacientes() throws ResourceNotFoundException {
        return pacienteService.buscarTodosPacientes();
    }
    @DeleteMapping("/eliminar/{id}")
    public Paciente eliminarPaciente(@PathVariable Long id) throws ResourceNotFoundException {
        Paciente paciente = pacienteService.buscarPaciente(id);
        pacienteService.eliminarPaciente(id);
        return paciente;
    }
    @PutMapping("/actualizar/{id}")
    public Paciente actualizarPaciente(@PathVariable Long id, @RequestBody Paciente paciente) throws ResourceNotFoundException {
        Paciente paciente1 = pacienteService.buscarPaciente(id);
        paciente1.setNombre(paciente.getNombre());
        paciente1.setApellido(paciente.getApellido());
        paciente1.setDni(paciente.getDni());
        paciente1.setDomicilio(paciente.getDomicilio());
        paciente1.setFechaAlta(paciente.getFechaAlta());
        pacienteService.actualizarPaciente(paciente1);
        return paciente1;
    }

}
