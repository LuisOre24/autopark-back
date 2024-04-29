package com.cibertec.autopark.controller;

import com.cibertec.autopark.dtos.ParqueoCreateDTO;
import com.cibertec.autopark.dtos.ParqueoDTO;
import com.cibertec.autopark.dtos.ParqueoResponseDTO;
import com.cibertec.autopark.service.ParqueoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ParqueoController {

    @Autowired
    private ParqueoService parqueoService;

    @GetMapping("parqueos")
    public ResponseEntity<List<ParqueoDTO>> listarParqueos(){
        return new ResponseEntity<>(parqueoService.listarParqueos(), HttpStatus.OK);
    }

    @GetMapping("/parqueos/{parqueoId}")
    public ResponseEntity<ParqueoDTO> obtenerParqueoPorId(@PathVariable("parqueoId") long parqueoId) {
        return new ResponseEntity<>(parqueoService.obtenerParqueoPorID(parqueoId),HttpStatus.OK);
    }

    @PostMapping("parqueos")
    public ResponseEntity<ParqueoResponseDTO> registrarParqueo(@RequestBody ParqueoCreateDTO parqueoCreateDTO){
        return new ResponseEntity<>(parqueoService.registrarParqueo(parqueoCreateDTO), HttpStatus.OK);
    }
}
