package com.cibertec.autoparkback.controller;

import com.cibertec.autoparkback.dto.VehiculoCreateDTO;
import com.cibertec.autoparkback.dto.VehiculoDTO;
import com.cibertec.autoparkback.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/vehiculo")
public class VehiculoController {

    @Autowired
    private IVehiculoService vehiculoService;


    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerVehiculo(@PathVariable("id") Integer id){
        if(vehiculoService.listarUno(id) != null){
            return new ResponseEntity<>(vehiculoService.listarUno(id), HttpStatus.OK);
        }
        return new ResponseEntity<>("Vehiculo no existe", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> crearVehiculo(@RequestBody VehiculoCreateDTO vehiculo){
        VehiculoDTO vehiculoRegistrada = vehiculoService.registrar(vehiculo);
        if(vehiculoRegistrada != null) {
            return new ResponseEntity<>(vehiculoRegistrada, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Error al registrar Vehiculo", HttpStatus.NOT_ACCEPTABLE);
    }

}
