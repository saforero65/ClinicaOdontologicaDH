package com.example.Clinica_Odontologica.services.impl;

import com.example.Clinica_Odontologica.model.Odontologo;
import com.example.Clinica_Odontologica.repository.OdontologoRepository;
import com.example.Clinica_Odontologica.services.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class OdontologoServiceImpl implements OdontologoService {

    private final OdontologoRepository odontologoRepository;

    @Autowired
    public OdontologoServiceImpl(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    public void crearOdontologo(Odontologo odontologo) {
        odontologoRepository.save(odontologo);
    }
    @Override
    public Odontologo buscarOdontologo(Long id) {
        Optional<Odontologo> odontologoOptional= odontologoRepository.findById(id);
        return odontologoOptional.orElse(null);
    }

}
