package com.cibertec.autopark.controller;

import com.cibertec.autopark.dtos.RegistroParqueoCreateDTO;
import com.cibertec.autopark.dtos.RegistroParqueoDTO;
import com.cibertec.autopark.dtos.RegistroParqueoUpdateDTO;
import com.cibertec.autopark.service.IRegistroParqueoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RegistroParqueoController {

    private final IRegistroParqueoService IRegistroParqueoService;

    public RegistroParqueoController(IRegistroParqueoService IRegistroParqueoService){
        this.IRegistroParqueoService = IRegistroParqueoService;
    }

    @GetMapping("registroparqueos")
    public ResponseEntity<List<RegistroParqueoDTO>> listarRegistroParqueos(){
        return   new ResponseEntity<>(IRegistroParqueoService.listarRegistroParqueos(), HttpStatus.OK);
    }

    @GetMapping("/registroparqueos/{registroParqueoId}")
    public ResponseEntity<RegistroParqueoDTO> obtenerRegistroParqueoPorId(@PathVariable("registroParqueoId") int registroParqueoId){
        return  new ResponseEntity<> ( IRegistroParqueoService.obtenerRegistroParqueoPorId(registroParqueoId),HttpStatus.OK);
    }

    @PostMapping("registroparqueos/ingreso")
    public ResponseEntity<RegistroParqueoDTO> registrarRegistroParqueo(@RequestBody RegistroParqueoCreateDTO registroParqueoCreateDTO){
        return  new ResponseEntity <>( IRegistroParqueoService.registrarRegistroParqueo(registroParqueoCreateDTO) ,HttpStatus.OK) ;
    }

//    @PutMapping("registroparqueos")
//    public ResponseEntity<RegistroParqueoDTO> actualizarRegistroParqueo(@RequestBody RegistroParqueoDTO registroParqueoUpdateDTO){
//        return new ResponseEntity<>(IRegistroParqueoService.actualizarRegistroParqueo(registroParqueoUpdateDTO),HttpStatus.OK);
//    }


    @PutMapping("registroparqueos/salida")
    public ResponseEntity<?> actualizarRegistroParqueo(@RequestBody RegistroParqueoUpdateDTO registroParqueoUpdateDTO){
        String rpta = IRegistroParqueoService.salidaVehiculo(registroParqueoUpdateDTO);
        return new ResponseEntity(HttpStatus.OK);
   }

    /*@DeleteMapping("/registroparqueos/{registroParqueoId}")
    public ResponseEntity<String> eliminarRegistroParqueo(@PathVariable("registroParqueoId") int registroParqueoId) {
        return new ResponseEntity<>( IRegistroParqueoService.eliminarRegistroParqueo(registroParqueoId),HttpStatus.OK);
    }*/
}
