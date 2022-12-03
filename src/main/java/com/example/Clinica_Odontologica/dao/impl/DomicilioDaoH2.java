package com.example.Clinica_Odontologica.dao.impl;

import com.example.Clinica_Odontologica.dao.IDao;
import com.example.Clinica_Odontologica.model.Domicilio;
import com.example.Clinica_Odontologica.model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DomicilioDaoH2 implements IDao<Domicilio> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:tcp://localhost/~/Clinica_Odontologica_test";
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "";

    private static final String SQL_CREATE_TABLE = "create table if not exists domicilio" +
            "(id int auto_increment primary key," +
            "calle varchar(255)," +
            "numero varchar (255)," +
            "localidad varchar (255)," +
            "provincia varchar (255)," +
            "pais varchar (255));";

    final static Logger LOGGER = Logger.getLogger(DomicilioDaoH2.class);

    public DomicilioDaoH2() {
    }

    public static Connection getConnection() throws Exception {
        Class.forName(DB_JDBC_DRIVER).newInstance();
        return DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
    }

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            //1 Levantar el driver y Conectarnos a la base de datos
            connection = getConnection();
            LOGGER.info("Conectado a la base de datos");
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);
            //2 Crear el statement
            preparedStatement = connection.prepareStatement("INSERT INTO domicilio (calle, numero, localidad,provincia,pais) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,domicilio.getCalle());
            preparedStatement.setString(2,domicilio.getNumero());
            preparedStatement.setString(3,domicilio.getLocalidad());
            preparedStatement.setString(4,domicilio.getProvincia());
            preparedStatement.setString(5,domicilio.getPais());

            //3 Ejecutar el statement
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                domicilio.setId(rs.getLong(1));
            }
            LOGGER.info("Se guardo el domicilio:" + domicilio);
            preparedStatement.close();
        }catch (Exception e){
            LOGGER.error("Error al guardar el domicilio: " + e.getMessage());
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                LOGGER.error("Error al cerrar la conexion");
            }
        }
        return domicilio;
    }

    @Override
    public void eliminar(Long id)  {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            //1 Levantar el driver y Conectarnos a la base de datos
            connection = getConnection();
            LOGGER.info("Conectado a la base de datos");
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);
            //2 Crear el statement
            preparedStatement = connection.prepareStatement("DELETE FROM domicilio WHERE id = ?");
            preparedStatement.setLong(1,id);

            //3 Ejecutar el statement
            preparedStatement.executeUpdate();
            LOGGER.info("Se elimino el domicilio con id: " + id);
            preparedStatement.close();
        }catch (Exception e){
            LOGGER.error("Error al eliminar el domicilio");
        }finally {
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
    public Domicilio buscar(Long id)  {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        System.out.println("entro a buscar ");
        try{
            //1 Levantar el driver y Conectarnos a la base de datos
            System.out.println("ANTES DE CONECTAR a la base de datos");
            connection = getConnection();
            LOGGER.info("Conectado a la base de datos");
            System.out.println("Conectado a la base de datos");
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);
            //2 Crear el statement
            preparedStatement = connection.prepareStatement("SELECT * FROM domicilio WHERE id = ?");
            preparedStatement.setLong(1,id);

            //3 Ejecutar el statement
            ResultSet resultSet = preparedStatement.executeQuery();
            //4 Recorrer el resultado
            while (resultSet.next()){
                Domicilio domicilio = new Domicilio();

                domicilio.setCalle(resultSet.getString("calle"));
                domicilio.setNumero(resultSet.getString("numero"));
                domicilio.setLocalidad(resultSet.getString("localidad"));
                domicilio.setProvincia(resultSet.getString("provincia"));
                domicilio.setPais(resultSet.getString("pais"));
                return domicilio;

            }
            LOGGER.info("Se busco el domicilio con id: " + id);
            preparedStatement.close();
        }catch (Exception e){
            LOGGER.error("Error al buscar el odontologo");
            System.out.println("error al entrar a buscar");
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
    public List<Domicilio> buscarTodos()  {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Domicilio> domicilios = new ArrayList<>();
        try{
            //1 Levantar el driver y Conectarnos a la base de datos
            connection = getConnection();
            LOGGER.info("Conectado a la base de datos");
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);
            //2 Crear el statement
            preparedStatement = connection.prepareStatement("SELECT * FROM domicilio");

            //3 Ejecutar el statement
            ResultSet resultSet = preparedStatement.executeQuery();
            //4 Recorrer el resultado
            while (resultSet.next()){


                String calle=resultSet.getString("calle");
                String numero=resultSet.getString("numero");
                String localidad=resultSet.getString("localidad");
                String provincia=resultSet.getString("provincia");
                String pais=resultSet.getString("pais");


                domicilios.add(new Domicilio(calle,numero,localidad,provincia,pais));

            }
            LOGGER.info("Se busco todos los odontologos");
            preparedStatement.close();
        }catch (Exception e){
            LOGGER.error("Error al buscar todos los odontologos");
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                LOGGER.error("Error al cerrar la conexion");
            }
        }
        return domicilios;
    }
}
