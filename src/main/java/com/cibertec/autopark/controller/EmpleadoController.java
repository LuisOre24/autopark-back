package com.cibertec.autopark.controller;
import com.cibertec.autopark.dtos.EmpleadoCreateDTO;
import com.cibertec.autopark.dtos.EmpleadoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmpleadoController {
    @Autowired
    private com.cibertec.autopark.service.EmpleadoService EmpleadoService;

    @GetMapping("/empleados")
    public ResponseEntity<List<EmpleadoDTO>> listarEmpleados(){
        return new ResponseEntity<>(EmpleadoService.listarEmpleados(), HttpStatus.OK);
    }

    @GetMapping("/empleados/{empleadoId}")
    public ResponseEntity<EmpleadoDTO> obtenerEmpleadoPorId(@PathVariable("empleadoId") Integer empleadoId){
        return new ResponseEntity<>(EmpleadoService.obtenerEmpleadoPorId(empleadoId), HttpStatus.OK);
    }

    @PostMapping("empleados")
    public ResponseEntity<EmpleadoDTO> registrarEmpleado(@RequestBody EmpleadoCreateDTO empleadoCreateDTO){
        return new ResponseEntity<>(EmpleadoService.registrarEmpleado(empleadoCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("empleados")
    public ResponseEntity<EmpleadoDTO> actualizarEmpleado(@RequestBody EmpleadoDTO empleadoUpdateDTO){
        return new ResponseEntity<>(EmpleadoService.actualizarEmpleado(empleadoUpdateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/empleados/{empleadoId}")
    public ResponseEntity<String> eliminarEmpleado(@PathVariable("empleadoId") Integer empleadoId){
        return new ResponseEntity<>(EmpleadoService.eliminarEmpleado(empleadoId), HttpStatus.OK);
    }

}

