package com.example.Clinica_Odontologica.services;

import com.example.Clinica_Odontologica.exception.ResourceNotFoundException;
import com.example.Clinica_Odontologica.model.Turno;

public interface TurnoService {

    void crearTurno(Turno turno) throws ResourceNotFoundException;
}
