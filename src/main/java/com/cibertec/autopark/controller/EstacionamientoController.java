package com.cibertec.autopark.controller;

import com.cibertec.autopark.dtos.EstacionamientoCreateDTO;
import com.cibertec.autopark.dtos.EstacionamientoDTO;
import com.cibertec.autopark.dtos.EstacionamientoUpdateDTO;
import com.cibertec.autopark.service.EstacionamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EstacionamientoController {
    @Autowired
    private EstacionamientoService EstacionamientoService;

    @GetMapping("/estacionamientos")
    public ResponseEntity<List<EstacionamientoDTO>> listarEstacionamientos(){
        return new ResponseEntity<>(EstacionamientoService.listarEstacionamientos(), HttpStatus.OK);
    }

    @GetMapping("/estacionamientos/{estacionamientoId}")
    public ResponseEntity<EstacionamientoDTO> obtenerEstacionamientoPorId(@PathVariable("estacionamientoId") Integer estacionamientoId){
        return new ResponseEntity<>(EstacionamientoService.obtenerEstacionamientoPorId(estacionamientoId), HttpStatus.OK);
    }

    @PostMapping("estacionamientos")
    public ResponseEntity<EstacionamientoDTO> registrarEstacionamiento(@RequestBody EstacionamientoCreateDTO estacionamientoCreateDTO){
        return new ResponseEntity<>(EstacionamientoService.registrarEstacionamiento(estacionamientoCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("estacionamientos")
    public ResponseEntity<EstacionamientoDTO> actualizarEstacionamiento(@RequestBody EstacionamientoUpdateDTO estacionamientoUpdateDTO){
        return new ResponseEntity<>(EstacionamientoService.actualizarEstacionamiento(estacionamientoUpdateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/estacionamientos/{estacionamientoId}")
    public ResponseEntity<String> eliminarEstacionamiento(@PathVariable("estacionamientoId") Integer estacionamientoId){
        return new ResponseEntity<>(EstacionamientoService.eliminarEstacionamiento(estacionamientoId), HttpStatus.OK);
    }

}
