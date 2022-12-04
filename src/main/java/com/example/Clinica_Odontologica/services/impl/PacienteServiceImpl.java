package com.example.Clinica_Odontologica.services.impl;

import com.example.Clinica_Odontologica.model.Paciente;
import com.example.Clinica_Odontologica.repository.PacienteRepository;
import com.example.Clinica_Odontologica.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;


    @Override
    public void crearPaciente(Paciente paciente) {
        pacienteRepository.save(paciente);
    }

    @Override
    public Paciente buscarPaciente(Long id) {
        return pacienteRepository.findById(id).orElse(null);

    }
}
