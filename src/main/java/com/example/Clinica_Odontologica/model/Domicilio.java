package com.example.Clinica_Odontologica.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "domicilio")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "domicilio")

public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "calle")
    private String calle;
    @Column(name = "numero")
    private String numero;
    @Column(name = "localidad")
    private String localidad;
    @Column(name = "provincia")
    private String provincia;
    @Column(name = "pais")
    private String pais;


}
