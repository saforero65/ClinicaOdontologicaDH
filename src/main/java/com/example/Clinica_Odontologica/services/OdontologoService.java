package com.example.Clinica_Odontologica.services;

import com.example.Clinica_Odontologica.exception.ResourceNotFoundException;
import com.example.Clinica_Odontologica.model.Odontologo;

import java.util.List;


public interface OdontologoService {
    void crearOdontologo(Odontologo odontologo) throws ResourceNotFoundException;
    Odontologo buscarOdontologo(Long id) throws ResourceNotFoundException;
    List<Odontologo> buscarTodosOdontologos() throws ResourceNotFoundException;
    void actualizarOdontologo(Odontologo odontologo) throws ResourceNotFoundException;
    void eliminarOdontologo(Long id) throws ResourceNotFoundException;



}
