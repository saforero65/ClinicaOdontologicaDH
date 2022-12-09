package com.example.Clinica_Odontologica.controller;


import com.example.Clinica_Odontologica.dto.OdontologoDto;
import com.example.Clinica_Odontologica.exception.ResourceNotFoundException;
import com.example.Clinica_Odontologica.model.Odontologo;
import com.example.Clinica_Odontologica.services.OdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/odontologo")
@CrossOrigin(origins = "*")
public class OdontologoController {
    private final OdontologoService odontologoService;
    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<OdontologoDto> buscarOdotologo(@PathVariable("id") Long id ) throws ResourceNotFoundException {
        Odontologo odontologo = odontologoService.buscarOdontologo(id);
        OdontologoDto odontologoDto = new OdontologoDto(odontologo.getId(), odontologo.getNombre(), odontologo.getApellido());
        return ResponseEntity.ok(odontologoDto);
    }
    @PostMapping("/guardar")
    public ResponseEntity<Odontologo> guardarOdontologo(@RequestBody Odontologo odontologo) throws ResourceNotFoundException {
        odontologoService.crearOdontologo(odontologo);
        return ResponseEntity.ok(odontologo);
    }
    @GetMapping("/buscarTodos")
    public ResponseEntity<Iterable<Odontologo>> buscarTodosOdontologos() throws ResourceNotFoundException {
        return ResponseEntity.ok(odontologoService.buscarTodosOdontologos());
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Odontologo> eliminarOdontologo(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Odontologo odontologo = odontologoService.buscarOdontologo(id);
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok(odontologo);
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Odontologo> actualizarOdontologo(@PathVariable("id") Long id, @RequestBody Odontologo odontologo) throws ResourceNotFoundException {
        Odontologo odontologo1 = odontologoService.buscarOdontologo(id);
        odontologo1.setNombre(odontologo.getNombre());
        odontologo1.setApellido(odontologo.getApellido());
        odontologoService.actualizarOdontologo(odontologo1);
        return ResponseEntity.ok(odontologo1);
    }
}
