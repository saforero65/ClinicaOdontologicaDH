package com.example.Clinica_Odontologica.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "odontologo")

public class Odontologo {
    //@GeneratedValue(strategy = GenerationType.AUTO) //autoincremental value for the primary key
    @Id    //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincremental value for the primary key

    private Long id;
    @Column(name = "nombre") //columna
    private String nombre;
    @Column(name = "apellido")//columna
    private String apellido;
    @Column(name = "matricula")//columna
    private String matricula;


}
