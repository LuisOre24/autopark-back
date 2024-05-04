package com.cibertec.autopark.controller;

import com.cibertec.autopark.dtos.MarcaCreateDTO;
import com.cibertec.autopark.dtos.MarcaDTO;
import com.cibertec.autopark.dtos.MarcaUpdateDTO;
import com.cibertec.autopark.service.IMarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MarcaController {
    @Autowired
    private IMarcaService IMarcaService;

    @GetMapping("/marcas")
    public ResponseEntity<List<MarcaDTO>> listarMarcas(){
        return new ResponseEntity<>(IMarcaService.listarMarcas(), HttpStatus.OK);
    }

    @GetMapping("/marcas/{marcaId}")
    public ResponseEntity<MarcaDTO> obtenerMarcaPorId(@PathVariable("marcaId") Integer marcaId){
        return new ResponseEntity<>(IMarcaService.obtenerMarcaPorId(marcaId), HttpStatus.OK);
    }

    @PostMapping("marcas")
    public ResponseEntity<MarcaDTO> registrarMarca(@RequestBody MarcaCreateDTO marcaCreateDTO){
        return new ResponseEntity<>(IMarcaService.registrarMarca(marcaCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("marcas")
    public ResponseEntity<MarcaDTO> actualizarMarca(@RequestBody MarcaUpdateDTO marcaUpdateDTO){
        return new ResponseEntity<>(IMarcaService.actualizarMarca(marcaUpdateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/marcas/{marcaId}")
    public ResponseEntity<String> eliminarMarca(@PathVariable("marcaId") Integer marcaId){
        return new ResponseEntity<>(IMarcaService.eliminarMarca(marcaId), HttpStatus.OK);
    }

}
