package com.cibertec.autoparkback.controller;

import com.cibertec.autoparkback.dto.MarcaCreateDTO;
import com.cibertec.autoparkback.dto.MarcaDTO;
import com.cibertec.autoparkback.service.IMarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/marca")
public class MarcaController {

    @Autowired
    private IMarcaService marcaService;


    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerMarca(@PathVariable("id") Integer id){
        if(marcaService.listarUno(id) != null){
            return new ResponseEntity<>(marcaService.listarUno(id), HttpStatus.OK);
        }
        return new ResponseEntity<>("Marca no existe", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> crearMarca(@RequestBody MarcaCreateDTO marca){
        MarcaDTO marcaRegistrada = marcaService.registrar(marca);
        if(marcaRegistrada != null) {
            return new ResponseEntity<>(marcaRegistrada, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Error al registrar Marca", HttpStatus.NOT_ACCEPTABLE);
    }

}
