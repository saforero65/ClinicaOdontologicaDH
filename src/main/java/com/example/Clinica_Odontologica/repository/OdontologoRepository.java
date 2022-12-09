package com.example.Clinica_Odontologica.repository;

import com.example.Clinica_Odontologica.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo,Long> {

    @Query("SELECT o FROM Odontologo o WHERE o.nombre = ?1")
    Odontologo findByNombre(String nombre);

    @Modifying
    @Query("UPDATE Odontologo o SET o.nombre = ?1, o.apellido = ?2 WHERE o.id = ?3")
    void actualizarOdontologo(String nombre, String apellido, Long id);







}

