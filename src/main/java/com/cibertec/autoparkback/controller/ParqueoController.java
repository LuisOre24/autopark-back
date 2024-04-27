package com.cibertec.autoparkback.controller;

import com.cibertec.autoparkback.dto.MarcaCreateDTO;
import com.cibertec.autoparkback.dto.MarcaDTO;
import com.cibertec.autoparkback.service.IMarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/parqueo")
public class ParqueoController {

    @Autowired
    private IMarcaService parqueoService;


    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerMarca(@PathVariable("id") Integer id){
        if(parqueoService.listarUno(id) != null){
            return new ResponseEntity<>(parqueoService.listarUno(id), HttpStatus.OK);
        }
        return new ResponseEntity<>("Marca no existe", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> crearMarca(@RequestBody MarcaCreateDTO parqueo){
        MarcaDTO parqueoRegistrada = parqueoService.registrar(parqueo);
        if(parqueoRegistrada != null) {
            return new ResponseEntity<>(parqueoRegistrada, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Error al registrar Marca", HttpStatus.NOT_ACCEPTABLE);
    }

}
