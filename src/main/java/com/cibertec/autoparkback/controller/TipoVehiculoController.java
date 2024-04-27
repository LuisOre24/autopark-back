package com.cibertec.autoparkback.controller;

import com.cibertec.autoparkback.dto.TipoVehiculoCreateDTO;
import com.cibertec.autoparkback.dto.TipoVehiculoDTO;
import com.cibertec.autoparkback.service.ITipoVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/tipo-vehiculo")
public class TipoVehiculoController {

    @Autowired
    private ITipoVehiculoService tipoVehiculoService;


    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerTipoVehiculo(@PathVariable("id") Integer id){
        if(tipoVehiculoService.listarUno(id) != null){
            return new ResponseEntity<>(tipoVehiculoService.listarUno(id), HttpStatus.OK);
        }
        return new ResponseEntity<>("TipoVehiculo no existe", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> crearTipoVehiculo(@RequestBody TipoVehiculoCreateDTO tipoVehiculo){
        TipoVehiculoDTO tipoVehiculoRegistrada = tipoVehiculoService.registrar(tipoVehiculo);
        if(tipoVehiculoRegistrada != null) {
            return new ResponseEntity<>(tipoVehiculoRegistrada, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Error al registrar TipoVehiculo", HttpStatus.NOT_ACCEPTABLE);
    }

}
