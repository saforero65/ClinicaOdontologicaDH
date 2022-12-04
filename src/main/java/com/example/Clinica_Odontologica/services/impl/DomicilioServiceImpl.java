package com.example.Clinica_Odontologica.services.impl;

import com.example.Clinica_Odontologica.model.Domicilio;
import com.example.Clinica_Odontologica.repository.DomicilioRepository;
import com.example.Clinica_Odontologica.services.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;

public class DomicilioServiceImpl implements DomicilioService {

@Autowired
private DomicilioRepository domicilioRepository;
    @Override
    public void crearDomicilio(Domicilio domicilio) {
        domicilioRepository.save(domicilio);
    }

    @Override
    public Domicilio buscarDomicilio(Long id) {
        return domicilioRepository.findById(id).orElse(null);
    }
}
