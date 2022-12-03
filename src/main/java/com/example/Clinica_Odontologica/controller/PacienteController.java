package com.example.Clinica_Odontologica.controller;

import com.example.Clinica_Odontologica.dao.IDao;
import com.example.Clinica_Odontologica.dao.impl.DomicilioDaoH2;
import com.example.Clinica_Odontologica.dao.impl.OdontologoDaoH2;
import com.example.Clinica_Odontologica.dao.impl.PacienteDaoH2;
import com.example.Clinica_Odontologica.model.Domicilio;
import com.example.Clinica_Odontologica.model.Paciente;
import com.example.Clinica_Odontologica.services.OdontologoService;
import com.example.Clinica_Odontologica.services.impl.OdontologoServiceImpl;
import com.example.Clinica_Odontologica.services.impl.PacienteService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

private final PacienteService pacienteService=new PacienteService(new PacienteDaoH2(new DomicilioDaoH2()));
    @GetMapping("/buscar/{id}")
    public Paciente buscarPaciente( @PathVariable Long id){
        Paciente paciente = pacienteService.buscar(id);
        return paciente;
    }
    @PostMapping("/guardar")
    public void guardarPaciente(@RequestBody Paciente paciente){
        pacienteService.guardar(paciente);
    }

}
