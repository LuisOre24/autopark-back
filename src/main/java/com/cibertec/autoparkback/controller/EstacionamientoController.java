package com.cibertec.autoparkback.controller;

import com.cibertec.autoparkback.dto.EstacionamientoCreateDTO;
import com.cibertec.autoparkback.dto.EstacionamientoDTO;
import com.cibertec.autoparkback.service.IEstacionamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/estacionamiento")
public class EstacionamientoController {

    @Autowired
    private IEstacionamientoService estacionamientoService;


    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerEstacionamiento(@PathVariable("id") Integer id){
        if(estacionamientoService.listarUno(id) != null){
            return new ResponseEntity<>(estacionamientoService.listarUno(id), HttpStatus.OK);
        }
        return new ResponseEntity<>("Estacionamiento no existe", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> crearEstacionamiento(@RequestBody EstacionamientoCreateDTO estacionamiento){
        EstacionamientoDTO estacionamientoRegistrada = estacionamientoService.registrar(estacionamiento);
        if(estacionamientoRegistrada != null) {
            return new ResponseEntity<>(estacionamientoRegistrada, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Error al registrar Estacionamiento", HttpStatus.NOT_ACCEPTABLE);
    }

}
