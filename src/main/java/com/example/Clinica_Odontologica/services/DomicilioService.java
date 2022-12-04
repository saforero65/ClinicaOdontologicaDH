package com.example.Clinica_Odontologica.services;

import com.example.Clinica_Odontologica.model.Domicilio;

public interface DomicilioService {
    void crearDomicilio(Domicilio domicilio);
    Domicilio buscarDomicilio(Long id);
}

