package com.example.Clinica_Odontologica.services.impl;

import com.example.Clinica_Odontologica.ClinicaOdontologicaApplication;
import com.example.Clinica_Odontologica.dto.OdontologoDto;
import com.example.Clinica_Odontologica.exception.ResourceNotFoundException;
import com.example.Clinica_Odontologica.model.Odontologo;
import com.example.Clinica_Odontologica.repository.OdontologoRepository;
import com.example.Clinica_Odontologica.services.OdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class OdontologoServiceImpl implements OdontologoService {

    final static org.apache.log4j.Logger LOGGER = Logger.getLogger(OdontologoServiceImpl.class);
    private final OdontologoRepository odontologoRepository;

    @Autowired
    public OdontologoServiceImpl(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void crearOdontologo(Odontologo odontologo) {
        OdontologoDto odontologoDto=objectMapper.convertValue(odontologo, OdontologoDto.class);
        odontologoRepository.save(odontologo);
    }
    @Override
    public Odontologo buscarOdontologo(Long id) throws ResourceNotFoundException {

        Optional<Odontologo> odontologoOptional= odontologoRepository.findById(id);
        if(odontologoOptional.isPresent()){

            return odontologoOptional.get();
        }else{
            LOGGER.error("No se encontro el odontologo con id: "+id);


            throw new ResourceNotFoundException("No se encontro el odontologo con id: "+id);
            //return odontologoOptional.get();
        }

    }

}
