package com.cibertec.autopark.controller;

import com.cibertec.autopark.dtos.MarcaCreateDTO;
import com.cibertec.autopark.dtos.MarcaDTO;
import com.cibertec.autopark.dtos.MarcaUpdateDTO;
import com.cibertec.autopark.repository.MarcaRepository;
import com.cibertec.autopark.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MarcaController {
    @Autowired
    private MarcaService marcaService;

    @GetMapping("/marcas")
    public ResponseEntity<List<MarcaDTO>> listarMarcas(){
        return new ResponseEntity<>(marcaService.listarMarcas(), HttpStatus.OK);
    }

    @GetMapping("/marcas/{marcaId}")
    public ResponseEntity<MarcaDTO> obtenerMarcaPorId(@PathVariable("marcaId") Integer marcaId){
        return new ResponseEntity<>(marcaService.obtenerMarcaPorId(marcaId), HttpStatus.OK);
    }

    @PostMapping("marcas")
    public ResponseEntity<MarcaDTO> registrarMarca(@RequestBody MarcaCreateDTO marcaCreateDTO){
        return new ResponseEntity<>(marcaService.registrarMarca(marcaCreateDTO), HttpStatus.OK);
    }

    @PutMapping("marcas")
    public ResponseEntity<MarcaDTO> actualizarMarca(@RequestBody MarcaUpdateDTO marcaUpdateDTO){
        return new ResponseEntity<>(marcaService.actualizarMarca(marcaUpdateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/marcas/{marcaId}")
    public ResponseEntity<String> eliminarMarca(@PathVariable("marcaId") Integer marcaId){
        return new ResponseEntity<>(marcaService.eliminarMarca(marcaId), HttpStatus.OK);
    }

}
