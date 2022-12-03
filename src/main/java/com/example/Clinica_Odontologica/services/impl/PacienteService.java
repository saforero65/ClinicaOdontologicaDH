package com.example.Clinica_Odontologica.services.impl;

import com.example.Clinica_Odontologica.dao.IDao;
import com.example.Clinica_Odontologica.model.Paciente;

import java.util.List;

public class PacienteService {
    private IDao<Paciente> pacienteDao;

    public PacienteService(IDao<Paciente> pacienteDao) {
        this.pacienteDao = pacienteDao;
    }
    public Paciente guardar(Paciente paciente){
        return pacienteDao.guardar(paciente);
    }
    public void eliminar(Long id){
        pacienteDao.eliminar(id);
    }
    public Paciente buscar(Long id){
        return pacienteDao.buscar(id);
    }
    public List<Paciente> buscarTodos(){
        return pacienteDao.buscarTodos();
    }

}
