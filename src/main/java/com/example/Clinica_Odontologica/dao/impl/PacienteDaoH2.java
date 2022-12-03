package com.example.Clinica_Odontologica.dao.impl;


import com.example.Clinica_Odontologica.dao.IDao;
import com.example.Clinica_Odontologica.model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class PacienteDaoH2 implements IDao<Paciente> {
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:tcp://localhost/~/prueba;";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";
    private static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS PACIENTE"
            + "(id int auto_increment primary key,"
            + "nombre varchar(255),"
            + "apellido varchar (255),"
            + "dni numeric (255),"
            + "domicilio varchar (255),"
            + "fechaAlta date)";

    final static Logger LOGGER = Logger.getLogger(PacienteDaoH2.class);

    public PacienteDaoH2() {
    }

    public static Connection getConnection() throws Exception {
        Class.forName(DB_JDBC_DRIVER).newInstance();
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    @Override
    public Paciente guardar(Paciente paciente) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //1 Levantar el driver y Conectarnos a la base de datos
            connection = getConnection();
            LOGGER.info("Conectado a la base de datos");
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);

            //2 Crear el statement

            preparedStatement = connection.prepareStatement("INSERT INTO PACIENTE  ( NOMBRE , APELLIDO ,DNI ,DOMICILIO ,FECHAALTA ) VALUES (? , ? , ? , ? , ? )");
            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setString(2, paciente.getApellido());
            preparedStatement.setInt(3, paciente.getDni());
            preparedStatement.setString(4, paciente.getDomicilio());
            preparedStatement.setDate(5, Date.valueOf(paciente.getFechaAlta()));

            //3 Ejecutar el statement
            preparedStatement.executeUpdate();
            LOGGER.info("Se guardo el paciente: " + paciente.getNombre() + " " + paciente.getApellido());
            preparedStatement.close();
        } catch (Exception e) {
            LOGGER.error("Error al guardar el paciente");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                LOGGER.error("Error al cerrar la conexion");
            }
        }
        return paciente;
    }

    @Override
    public void eliminar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //1 Levantar el driver y Conectarnos a la base de datos
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);

            //2 Crear el statement
            preparedStatement = connection.prepareStatement("DELETE FROM paciente WHERE id = ?");
            preparedStatement.setLong(1, id);

            //3 Ejecutar el statement
            preparedStatement.executeUpdate();
            LOGGER.info("Se elimino el paciente con id: " + id);
            preparedStatement.close();
        } catch (Exception e) {
            LOGGER.error("Error al eliminar el paciente");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                LOGGER.error("Error al cerrar la conexion");
            }
        }
    }

    @Override
    public Paciente buscar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //1 Levantar el driver y Conectarnos a la base de datos
            connection = getConnection();
            LOGGER.info("Conectado a la base de datos");
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);
            //2 Crear el statement
            preparedStatement = connection.prepareStatement("SELECT * FROM paciente WHERE id = ?");
            preparedStatement.setLong(1, id);
            LOGGER.info("Query " + preparedStatement);

            //3 Ejecutar el statement
            ResultSet resultSet = preparedStatement.executeQuery();
            //4 Recorrer el resultado
            while (resultSet.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(resultSet.getLong("id"));
                paciente.setNombre(resultSet.getString("nombre"));
                paciente.setApellido(resultSet.getString("apellido"));
                paciente.setDni(resultSet.getInt("dni"));
                paciente.setDomicilio(resultSet.getString("domicilio"));
                paciente.setFechaAlta(resultSet.getDate("fechaAlta").toLocalDate());

                LOGGER.info("Se encontro el paciente: " + paciente.getNombre() + " " + paciente.getApellido());
                return paciente;
            }
            LOGGER.info("Se busco el paciente con id: " + id);

            preparedStatement.close();
        } catch (Exception e) {
            LOGGER.error("Error al buscar el paciente");
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                LOGGER.error("Error al cerrar la conexion");
            }
        }
        return null;
    }

    @Override
    public List<Paciente> buscarTodos() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Paciente> pacientes = new ArrayList<>();
        try {
            //1 Levantar el driver y Conectarnos a la base de datos
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);
            //2 Crear el statement
            preparedStatement = connection.prepareStatement("SELECT * FROM paciente");

            //3 Ejecutar el statement
            ResultSet resultSet = preparedStatement.executeQuery();
            //4 Recorrer el resultado
            while (resultSet.next()) {

                Long id = resultSet.getLong("id");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                int dni = resultSet.getInt("dni");
                String domicilio = resultSet.getString("domicilio");
                LocalDate fechaAlta = resultSet.getDate("fechaAlta").toLocalDate();

                pacientes.add(new Paciente(id, nombre, apellido, dni, domicilio, fechaAlta));
            }
            LOGGER.info("Se busco todos los pacientes");
            preparedStatement.close();
        } catch (Exception e) {
            LOGGER.error("Error al buscar todos los pacientes");
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                LOGGER.error("Error al cerrar la conexion");
            }
        }
        return pacientes;
    }
}
