package com.example.Clinica_Odontologica.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {
    T guardar(T t) throws SQLException;
    void eliminar(Long id) throws SQLException;
    T buscar(Long id) throws SQLException;
    List<T> buscarTodos() throws SQLException;
}
