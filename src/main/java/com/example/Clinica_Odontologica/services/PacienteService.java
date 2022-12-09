package com.example.Clinica_Odontologica.services;

import com.example.Clinica_Odontologica.exception.ResourceNotFoundException;
import com.example.Clinica_Odontologica.model.Odontologo;
import com.example.Clinica_Odontologica.model.Paciente;

import java.util.List;

public interface PacienteService {
    void crearPaciente(Paciente paciente) throws ResourceNotFoundException;
    Paciente buscarPaciente(Long id) throws ResourceNotFoundException;
    List<Paciente> buscarTodosPacientes() throws ResourceNotFoundException;
    void actualizarPaciente(Paciente paciente) throws ResourceNotFoundException;
    void eliminarPaciente(Long id) throws ResourceNotFoundException;

}

