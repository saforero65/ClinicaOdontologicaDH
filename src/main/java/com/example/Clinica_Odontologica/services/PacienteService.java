package com.example.Clinica_Odontologica.services;

import com.example.Clinica_Odontologica.model.Paciente;

public interface PacienteService {
    void crearPaciente(Paciente paciente);
    Paciente buscarPaciente(Long id);
}

