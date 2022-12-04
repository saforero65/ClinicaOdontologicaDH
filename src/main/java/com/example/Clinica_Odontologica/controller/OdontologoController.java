package com.example.Clinica_Odontologica.controller;


import com.example.Clinica_Odontologica.dto.OdontologoDto;
import com.example.Clinica_Odontologica.model.Odontologo;
import com.example.Clinica_Odontologica.services.OdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/odontologo")
public class OdontologoController {
    private final OdontologoService odontologoService;
    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    //private final OdontologoService odontologoService= new OdontologoServiceImpl( new OdontologoDaoH2());

    @GetMapping("/buscar/{id}")
    public ResponseEntity<OdontologoDto> buscarOdotologo(@PathVariable("id") Long id ) {
        Odontologo odontologo = odontologoService.buscarOdontologo(id);
        OdontologoDto odontologoDto = new OdontologoDto(odontologo.getId(), odontologo.getNombre(), odontologo.getApellido());
        return ResponseEntity.ok(odontologoDto);

    }
    @PostMapping("/guardar")
    public Odontologo guardarOdontologo(@RequestBody Odontologo odontologo)  {
        odontologoService.crearOdontologo(odontologo);
        return odontologo;
    }
}
