package com.example.Clinica_Odontologica.services;

import com.example.Clinica_Odontologica.dao.IDao;
import com.example.Clinica_Odontologica.model.Paciente;
import java.sql.SQLException;
import java.util.List;

public class PacienteService  {

    private IDao<Paciente> pacienteDao;
    public PacienteService(){
    }
    public PacienteService(IDao<Paciente> pacienteDao){
        this.pacienteDao = pacienteDao;
    }
    public void setPacienteDao(IDao<Paciente> pacienteDao){
        this.pacienteDao = pacienteDao;
    }
    public Paciente guardarPaciente(Paciente paciente) throws SQLException {
        return pacienteDao.guardar(paciente);
    }
    public void eliminarPaciente(Long id) throws SQLException {
        pacienteDao.eliminar(id);
    }
    public Paciente buscarPaciente(Long id) throws SQLException {
        return pacienteDao.buscar(id);
    }

    public List<Paciente> buscarTodosPacientes() throws SQLException {
        return pacienteDao.buscarTodos();
    }

}
