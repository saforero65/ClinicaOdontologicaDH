package com.example.Clinica_Odontologica.repository;

import com.example.Clinica_Odontologica.model.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {

}

