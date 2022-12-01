package com.example.Clinica_Odontologica.model;

import java.time.LocalDate;

public class Paciente {
    private Long id;
    private String nombre;
    private String apellido;
    private int dni;
    private String domicilio;
    private LocalDate fechaAlta;

    public Paciente(){

    }
    public Paciente(String nombre, String apellido, int dni, String domicilio,LocalDate fechaAlta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
        this.fechaAlta = fechaAlta;
    }
    public Paciente(Long id,String nombre, String apellido, int dni, String domicilio,LocalDate fechaAlta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
        this.fechaAlta = fechaAlta;
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }
    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
}