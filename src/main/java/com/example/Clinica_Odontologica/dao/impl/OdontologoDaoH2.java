package com.example.Clinica_Odontologica.dao.impl;

import com.example.Clinica_Odontologica.dao.IDao;
import com.example.Clinica_Odontologica.model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:tcp://localhost/~/prueba";
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "";

    private static final String SQL_CREATE_TABLE = "create table if not exists odontologo" +
            "(id int auto_increment primary key," +
            "nombre varchar(255)," +
            "apellido varchar (255)," +
            "matricula varchar (255));";

    final static Logger LOGGER = Logger.getLogger(OdontologoDaoH2.class);

    public OdontologoDaoH2() {
    }

    public static Connection getConnection() throws Exception {
        Class.forName(DB_JDBC_DRIVER).newInstance();
        return DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            //1 Levantar el driver y Conectarnos a la base de datos
            connection = getConnection();
            LOGGER.info("Conectado a la base de datos");
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);
            //2 Crear el statement
            preparedStatement = connection.prepareStatement("INSERT INTO odontologo (nombre, apellido, matricula) VALUES (?,?,?)");
            preparedStatement.setString(1,odontologo.getNombre());
            preparedStatement.setString(2,odontologo.getApellido());
            preparedStatement.setString(3,odontologo.getMatricula());

            //3 Ejecutar el statement
            preparedStatement.executeUpdate();
            LOGGER.info("Se guardo el odontologo: " + odontologo.getNombre() + " " + odontologo.getApellido());
            preparedStatement.close();
        }catch (Exception e){
            LOGGER.error("Error al guardar el odontologo: " + e.getMessage());
        }finally {
            connection.close();
        }
        return odontologo;
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            //1 Levantar el driver y Conectarnos a la base de datos
            connection = getConnection();
            LOGGER.info("Conectado a la base de datos");
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);
            //2 Crear el statement
            preparedStatement = connection.prepareStatement("DELETE FROM odontologo WHERE id = ?");
            preparedStatement.setLong(1,id);

            //3 Ejecutar el statement
            preparedStatement.executeUpdate();
            LOGGER.info("Se elimino el odontologo con id: " + id);
            preparedStatement.close();
        }catch (Exception e){
            LOGGER.error("Error al eliminar el odontologo");
        }finally {
            connection.close();
        }

    }

    @Override
    public Odontologo buscar(Long id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            //1 Levantar el driver y Conectarnos a la base de datos
            connection = getConnection();
            LOGGER.info("Conectado a la base de datos");
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);
            //2 Crear el statement
            preparedStatement = connection.prepareStatement("SELECT * FROM odontologo WHERE id = ?");
            preparedStatement.setLong(1,id);

            //3 Ejecutar el statement
            ResultSet resultSet = preparedStatement.executeQuery();
            //4 Recorrer el resultado
            while (resultSet.next()){
                Odontologo odontologo = new Odontologo();
                odontologo.setId(resultSet.getLong("id"));
                odontologo.setNombre(resultSet.getString("nombre"));
                odontologo.setApellido(resultSet.getString("apellido"));
                odontologo.setMatricula(resultSet.getString("matricula"));
                return odontologo;
            }
            LOGGER.info("Se busco el odontologo con id: " + id);
            preparedStatement.close();
        }catch (Exception e){
            LOGGER.error("Error al buscar el odontologo");
        }finally {
            connection.close();
        }
        return null;
    }

    @Override
    public List<Odontologo> buscarTodos() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Odontologo> odontologos = new ArrayList<>();
        try{
            //1 Levantar el driver y Conectarnos a la base de datos
            connection = getConnection();
            LOGGER.info("Conectado a la base de datos");
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);
            //2 Crear el statement
            preparedStatement = connection.prepareStatement("SELECT * FROM odontologo");

            //3 Ejecutar el statement
            ResultSet resultSet = preparedStatement.executeQuery();
            //4 Recorrer el resultado
            while (resultSet.next()){

               Long id=resultSet.getLong("id");
               String nombre=resultSet.getString("nombre");
               String apellido= resultSet.getString("apellido");
               String matricula= resultSet.getString("matricula");
                odontologos.add(new Odontologo( id, nombre, apellido, matricula));
            }
            LOGGER.info("Se busco todos los odontologos");
            preparedStatement.close();
        }catch (Exception e){
            LOGGER.error("Error al buscar todos los odontologos");
        }finally {
            connection.close();
        }
        return odontologos;
    }
}
