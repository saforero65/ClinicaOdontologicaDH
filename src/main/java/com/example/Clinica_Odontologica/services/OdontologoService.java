package com.example.Clinica_Odontologica.services;

import com.example.Clinica_Odontologica.model.Odontologo;

import java.sql.SQLException;

public interface OdontologoService {
    Odontologo obtenerOdontologo(Long id) throws SQLException;
}
