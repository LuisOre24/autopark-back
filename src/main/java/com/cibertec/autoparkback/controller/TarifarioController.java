package com.cibertec.autoparkback.controller;

import com.cibertec.autoparkback.dto.TarifarioCreateDTO;
import com.cibertec.autoparkback.dto.TarifarioDTO;
import com.cibertec.autoparkback.service.ITarifarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/tarifa")
public class TarifarioController {

    @Autowired
    private ITarifarioService tarifaService;


    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerTarifario(@PathVariable("id") Integer id){
        if(tarifaService.listarUno(id) != null){
            return new ResponseEntity<>(tarifaService.listarUno(id), HttpStatus.OK);
        }
        return new ResponseEntity<>("Tarifario no existe", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> crearTarifario(@RequestBody TarifarioCreateDTO tarifa){
        TarifarioDTO tarifaRegistrada = tarifaService.registrar(tarifa);
        if(tarifaRegistrada != null) {
            return new ResponseEntity<>(tarifaRegistrada, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Error al registrar Tarifario", HttpStatus.NOT_ACCEPTABLE);
    }

}
