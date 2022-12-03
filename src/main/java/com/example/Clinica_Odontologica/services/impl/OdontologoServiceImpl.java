package com.example.Clinica_Odontologica.services.impl;

import com.example.Clinica_Odontologica.dao.IDao;
import com.example.Clinica_Odontologica.model.Odontologo;
import com.example.Clinica_Odontologica.services.OdontologoService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class OdontologoServiceImpl implements OdontologoService {
    private IDao<Odontologo> odontologoDao;
    public OdontologoServiceImpl(){
    }
    public OdontologoServiceImpl(IDao<Odontologo> odontologoDao){

        this.odontologoDao = odontologoDao;
    }
    @Override
    public Odontologo obtenerOdontologo(Long id) {
        return odontologoDao.buscar(id);
    }

    @Override
    public Odontologo guardarOdontologo(Odontologo odontologo) {
        return odontologoDao.guardar(odontologo);
    }
}
