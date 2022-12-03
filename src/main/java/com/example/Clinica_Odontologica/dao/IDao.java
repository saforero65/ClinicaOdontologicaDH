package com.example.Clinica_Odontologica.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {
    T guardar(T t) ;
    void eliminar(Long id) ;
    T buscar(Long id) ;
    List<T> buscarTodos() ;
}
