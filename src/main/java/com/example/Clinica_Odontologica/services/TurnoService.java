package com.example.Clinica_Odontologica.services;

import com.example.Clinica_Odontologica.exception.ResourceNotFoundException;
import com.example.Clinica_Odontologica.model.Turno;

import java.util.List;

public interface TurnoService {

    Turno crearTurno(Turno turno) throws ResourceNotFoundException;

    Turno buscarTurno(Long id) throws ResourceNotFoundException;

    List<Turno> buscarTodosTurnos() throws ResourceNotFoundException;
}
