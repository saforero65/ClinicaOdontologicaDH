package com.example.Clinica_Odontologica.services;

import com.example.Clinica_Odontologica.dto.OdontologoDto;
import com.example.Clinica_Odontologica.exception.ResourceNotFoundException;
import com.example.Clinica_Odontologica.model.Odontologo;

import java.sql.SQLException;
import java.util.Optional;

public interface OdontologoService {
    void crearOdontologo(Odontologo odontologo);

    Odontologo buscarOdontologo(Long id) throws ResourceNotFoundException;



}
