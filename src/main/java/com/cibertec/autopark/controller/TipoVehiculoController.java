package com.cibertec.autopark.controller;

import com.cibertec.autopark.dtos.TipoVehiculoCreateDTO;
import com.cibertec.autopark.dtos.TipoVehiculoDTO;
import com.cibertec.autopark.dtos.TipoVehiculoUpdateDTO;
import com.cibertec.autopark.service.ITipoVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TipoVehiculoController {
    @Autowired
    private ITipoVehiculoService ITipoVehiculoService;

    @GetMapping("/tipoVehiculos")
    public ResponseEntity<List<TipoVehiculoDTO>> listarTipoVehiculos(){
        return new ResponseEntity<>(ITipoVehiculoService.listarTipoVehiculos(), HttpStatus.OK);
    }

    @GetMapping("/tipoVehiculos/{tipoVehiculoId}")
    public ResponseEntity<TipoVehiculoDTO> obtenerTipoVehiculoPorId(@PathVariable("tipoVehiculoId") Integer tipoVehiculoId){
        return new ResponseEntity<>(ITipoVehiculoService.obtenerTipoVehiculoPorId(tipoVehiculoId), HttpStatus.OK);
    }

    @PostMapping("tipoVehiculos")
    public ResponseEntity<TipoVehiculoDTO> registrarTipoVehiculo(@RequestBody TipoVehiculoCreateDTO tipoVehiculoCreateDTO){
        return new ResponseEntity<>(ITipoVehiculoService.registrarTipoVehiculo(tipoVehiculoCreateDTO), HttpStatus.OK);
    }

    @PutMapping("tipoVehiculos")
    public ResponseEntity<TipoVehiculoDTO> actualizarTipoVehiculo(@RequestBody TipoVehiculoUpdateDTO tipoVehiculoUpdateDTO){
        return new ResponseEntity<>(ITipoVehiculoService.actualizarTipoVehiculo(tipoVehiculoUpdateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/tipoVehiculos/{tipoVehiculoId}")
    public ResponseEntity<String> eliminarTipoVehiculo(@PathVariable("tipoVehiculoId") Integer tipoVehiculoId){
        return new ResponseEntity<>(ITipoVehiculoService.eliminarTipoVehiculo(tipoVehiculoId), HttpStatus.OK);
    }

}
