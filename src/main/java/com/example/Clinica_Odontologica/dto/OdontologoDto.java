package com.example.Clinica_Odontologica.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class OdontologoDto {
    private Long id;
    private String nombre;
    private String apellido;


    public OdontologoDto(){

    }
    public OdontologoDto(String nombre, String apellido ) {

        this.nombre = nombre;
        this.apellido = apellido;

    }
    public OdontologoDto(Long id,String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;

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


}

