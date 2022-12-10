package com.example.Clinica_Odontologica.services.impl;

import com.example.Clinica_Odontologica.exception.ResourceNotFoundException;
import com.example.Clinica_Odontologica.model.Paciente;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PacienteServiceImplTest {

    private PacienteServiceImpl pacienteService;

    @Test
    public void testCrearPaciente() throws ResourceNotFoundException {
        Paciente paciente = new Paciente();
        paciente.setNombre("Juan");
        paciente.setApellido("Perez");
        paciente.setDni(123);
        pacienteService.crearPaciente(paciente);
        Paciente pacienteJuan = pacienteService.buscarPaciente(1L);
        assertNotNull(pacienteJuan);
    }
    @Test
    public void testBuscarPaciente() throws ResourceNotFoundException {
        Paciente paciente = new Paciente();
        paciente.setNombre("Juan");
        paciente.setApellido("Perez");
        paciente.setDni(123);
        pacienteService.crearPaciente(paciente);
        Paciente pacienteJuan = pacienteService.buscarPaciente(1L);
        assertNotNull(pacienteJuan);
    }
}