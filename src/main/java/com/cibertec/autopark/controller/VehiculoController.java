package com.cibertec.autopark.controller;

import com.cibertec.autopark.dtos.VehiculoCreateDTO;
import com.cibertec.autopark.dtos.VehiculoDTO;
import com.cibertec.autopark.dtos.VehiculoUpdateDTO;
import com.cibertec.autopark.service.IVehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class VehiculoController {

    private final IVehiculoService IVehiculoService;
    public VehiculoController(IVehiculoService IVehiculoService){
        this.IVehiculoService = IVehiculoService;
    }

    @Operation(summary = "Endpoint que  permite listar los vehiculos", description = "Endpoint que  permite listar los vehiculos")
    @GetMapping("vehiculos")
    public ResponseEntity<List<VehiculoDTO>> listarVehiculos(){
        return new ResponseEntity<>(IVehiculoService.listarVehiculos(), HttpStatus.OK);
    }

    @Operation(summary = "Endpoint que  permite obtener un vehiculo por ID", description = "Endpoint que  permite obtener un vehiculo por ID")
    @GetMapping("/vehiculos/{vehiculoId}")
    public ResponseEntity<VehiculoDTO> obtenerVehiculoPorId(@PathVariable("vehiculoId") Integer vehiculoId){
        return  new ResponseEntity<> ( IVehiculoService.obtenerVehiculoPorID(vehiculoId),HttpStatus.OK);
    }

    @Operation(summary = "Endpoint que  permite registrar un nuevo vehiculo", description = "Endpoint que  permite registrar un nuevo vehiculo")
    @PostMapping("vehiculos")
    public ResponseEntity<VehiculoDTO> registrarVehiculo(@RequestBody VehiculoCreateDTO vehiculoCreateDTO){
        return  new ResponseEntity<>( IVehiculoService.registrarVehiculo(vehiculoCreateDTO) ,HttpStatus.OK) ;
    }

    @Operation(summary = "Endpoint que  permite actualizar un vehiculo existente", description = "Endpoint que  permite actualizar un vehiculo existente")
    @PutMapping("vehiculos")
    public ResponseEntity<VehiculoDTO> actualizarVehiculo(@RequestBody VehiculoUpdateDTO vehiculoUpdateDTO){
        return new ResponseEntity<>(IVehiculoService.actualizarVehiculo(vehiculoUpdateDTO),HttpStatus.OK);
    }

    @Operation(summary = "Endpoint que  permite eliminar un vehiculo por ID", description = "Endpoint que  permite eliminar un vehiculo por ID")
    @DeleteMapping("/vehiculos/{vehiculoId}")
    public ResponseEntity<String> eliminarVehiculo(@PathVariable("vehiculoId") Integer vehiculoId) {
        return new ResponseEntity<>( IVehiculoService.eliminarVehiculo(vehiculoId),HttpStatus.OK);
    }
}
