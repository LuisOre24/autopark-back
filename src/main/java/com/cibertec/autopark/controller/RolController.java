package com.cibertec.autopark.controller;

import com.cibertec.autopark.dtos.RolCreateDTO;
import com.cibertec.autopark.dtos.RolDTO;
import com.cibertec.autopark.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RolController {
    @Autowired
    private RolService RolService;

    @GetMapping("/roles")
    public ResponseEntity<List<RolDTO>> listarRoles(){
        return new ResponseEntity<>(RolService.listarRoles(), HttpStatus.OK);
    }

    @GetMapping("/roles/{marcaId}")
    public ResponseEntity<RolDTO> obtenerRolPorId(@PathVariable("marcaId") Integer marcaId){
        return new ResponseEntity<>(RolService.obtenerRolPorId(marcaId), HttpStatus.OK);
    }

    @PostMapping("roles")
    public ResponseEntity<RolDTO> registrarRol(@RequestBody RolCreateDTO marcaCreateDTO){
        return new ResponseEntity<>(RolService.registrarRol(marcaCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("roles")
    public ResponseEntity<RolDTO> actualizarRol(@RequestBody RolDTO marcaUpdateDTO){
        return new ResponseEntity<>(RolService.actualizarRol(marcaUpdateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/roles/{marcaId}")
    public ResponseEntity<String> eliminarRol(@PathVariable("marcaId") Integer marcaId){
        return new ResponseEntity<>(RolService.eliminarRol(marcaId), HttpStatus.OK);
    }

}

