package com.cibertec.autopark.controller;

import com.cibertec.autopark.dtos.TarifarioCreateDTO;
import com.cibertec.autopark.dtos.TarifarioDTO;
import com.cibertec.autopark.service.ITarifarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TarifarioController {
    @Autowired
    private ITarifarioService ITarifarioService;

    @GetMapping("/tarifarios")
    public ResponseEntity<List<TarifarioDTO>> listarTarifarios(){
        return new ResponseEntity<>(ITarifarioService.listarTarifarios(), HttpStatus.OK);
    }

    @GetMapping("/tarifarios/{tarifarioId}")
    public ResponseEntity<TarifarioDTO> obtenerTarifarioPorId(@PathVariable("tarifarioId") Integer tarifarioId){
        return new ResponseEntity<>(ITarifarioService.obtenerTarifarioPorId(tarifarioId), HttpStatus.OK);
    }

    @PostMapping("tarifarios")
    public ResponseEntity<TarifarioDTO> registrarTarifario(@RequestBody TarifarioCreateDTO tarifarioCreateDTO){
        return new ResponseEntity<>(ITarifarioService.registrarTarifario(tarifarioCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("tarifarios")
    public ResponseEntity<TarifarioDTO> actualizarTarifario(@RequestBody TarifarioDTO tarifarioUpdateDTO){
        return new ResponseEntity<>(ITarifarioService.actualizarTarifario(tarifarioUpdateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/tarifarios/{tarifarioId}")
    public ResponseEntity<?> eliminarTarifario(@PathVariable("tarifarioId") Integer tarifarioId){
        String text =ITarifarioService.eliminarTarifario(tarifarioId);
        return new ResponseEntity<>( HttpStatus.OK);
    }

}
