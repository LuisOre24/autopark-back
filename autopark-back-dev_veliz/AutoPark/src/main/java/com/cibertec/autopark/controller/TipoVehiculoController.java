package com.cibertec.autopark.controller;

import com.cibertec.autopark.dtos.TipoVehiculoCreateDTO;
import com.cibertec.autopark.dtos.TipoVehiculoDTO;
import com.cibertec.autopark.dtos.TipoVehiculoUpdateDTO;
import com.cibertec.autopark.service.TipoVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TipoVehiculoController {
    @Autowired
    private TipoVehiculoService tipoVehiculoService;

    @GetMapping("/tipoVehiculos")
    public ResponseEntity<List<TipoVehiculoDTO>> listarTipoVehiculos(){
        return new ResponseEntity<>(tipoVehiculoService.listarTipoVehiculos(), HttpStatus.OK);
    }

    @GetMapping("/tipoVehiculos/{tipoVehiculoId}")
    public ResponseEntity<TipoVehiculoDTO> obtenerTipoVehiculoPorId(@PathVariable("tipoVehiculoId") Integer tipoVehiculoId){
        return new ResponseEntity<>(tipoVehiculoService.obtenerTipoVehiculoPorId(tipoVehiculoId), HttpStatus.OK);
    }

    @PostMapping("tipoVehiculos")
    public ResponseEntity<TipoVehiculoDTO> registrarTipoVehiculo(@RequestBody TipoVehiculoCreateDTO tipoVehiculoCreateDTO){
        return new ResponseEntity<>(tipoVehiculoService.registrarTipoVehiculo(tipoVehiculoCreateDTO), HttpStatus.OK);
    }

    @PutMapping("tipoVehiculos")
    public ResponseEntity<TipoVehiculoDTO> actualizarTipoVehiculo(@RequestBody TipoVehiculoUpdateDTO tipoVehiculoUpdateDTO){
        return new ResponseEntity<>(tipoVehiculoService.actualizarTipoVehiculo(tipoVehiculoUpdateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/tipoVehiculos/{tipoVehiculoId}")
    public ResponseEntity<String> eliminarTipoVehiculo(@PathVariable("tipoVehiculoId") Integer tipoVehiculoId){
        return new ResponseEntity<>(tipoVehiculoService.eliminarTipoVehiculo(tipoVehiculoId), HttpStatus.OK);
    }

}
