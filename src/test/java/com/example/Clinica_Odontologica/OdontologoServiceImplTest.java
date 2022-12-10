package com.example.Clinica_Odontologica;

import com.example.Clinica_Odontologica.exception.ResourceNotFoundException;
import com.example.Clinica_Odontologica.model.Odontologo;
import com.example.Clinica_Odontologica.services.impl.OdontologoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OdontologoServiceImplTest {
    private OdontologoServiceImpl odontologoService;
    @Test
    public void testCrearOdontologo() throws ResourceNotFoundException {
        Odontologo odontologo = new Odontologo();
        odontologo.setNombre("Juan");
        odontologo.setApellido("Perez");
        odontologo.setMatricula("1234");
        odontologoService.crearOdontologo(odontologo);
        Odontologo odontologoJuan = odontologoService.buscarOdontologo(1L);
        assertNotNull(odontologoJuan);
    }
    @Test
    public void testBuscarOdontologo() throws ResourceNotFoundException {
        Odontologo odontologo = new Odontologo();
        odontologo.setNombre("Juan");
        odontologo.setApellido("Perez");
        odontologo.setMatricula("1234");
        odontologoService.crearOdontologo(odontologo);
        Odontologo odontologoJuan = odontologoService.buscarOdontologo(1L);
        assertNotNull(odontologoJuan);
    }


}