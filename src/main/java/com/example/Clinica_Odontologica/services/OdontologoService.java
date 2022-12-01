package com.example.Clinica_Odontologica.services;



import com.example.Clinica_Odontologica.dao.IDao;
import com.example.Clinica_Odontologica.model.Odontologo;

import java.sql.SQLException;
import java.util.List;

public class OdontologoService {
    private IDao<Odontologo> odontologoDao;
    public OdontologoService(){
    }
    public OdontologoService(IDao<Odontologo> odontologoDao){
        this.odontologoDao = odontologoDao;
    }
    public void setOdontologoDao(IDao<Odontologo> odontologoDao){
        this.odontologoDao = odontologoDao;
    }
    public Odontologo guardarOdontologo(Odontologo odontologo) throws SQLException {
        return odontologoDao.guardar(odontologo);
    }
    public void eliminarOdontologo(Long id) throws SQLException {
        odontologoDao.eliminar(id);
    }
    public Odontologo buscarOdontologo(Long id) throws SQLException {
        return odontologoDao.buscar(id);
    }
    public List<Odontologo> buscarTodosOdontologos() throws SQLException {
        return odontologoDao.buscarTodos();
    }
}
