package com.cibertec.autopark.controller;

import com.cibertec.autopark.dtos.TipoDocumentoCreateDTO;
import com.cibertec.autopark.dtos.TipoDocumentoDTO;
import com.cibertec.autopark.dtos.TipoDocumentoUpdateDTO;
import com.cibertec.autopark.service.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TipoDocumentoController {
    @Autowired
    private TipoDocumentoService TipoDocumentoService;

    @GetMapping("/tipoDocumentos")
    public ResponseEntity<List<TipoDocumentoDTO>> listarTipoDocumentos(){
        return new ResponseEntity<>(TipoDocumentoService.listarTipoDocumentos(), HttpStatus.OK);
    }

    @GetMapping("/tipoDocumentos/{tipoDocumentoId}")
    public ResponseEntity<TipoDocumentoDTO> obtenerTipoDocumentoPorId(@PathVariable("tipoDocumentoId") Integer tipoDocumentoId){
        return new ResponseEntity<>(TipoDocumentoService.obtenerTipoDocumentoPorId(tipoDocumentoId), HttpStatus.OK);
    }

    @PostMapping("tipoDocumentos")
    public ResponseEntity<TipoDocumentoDTO> registrarTipoDocumento(@RequestBody TipoDocumentoCreateDTO tipoDocumentoCreateDTO){
        return new ResponseEntity<>(TipoDocumentoService.registrarTipoDocumento(tipoDocumentoCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("tipoDocumentos")
    public ResponseEntity<TipoDocumentoDTO> actualizarTipoDocumento(@RequestBody TipoDocumentoUpdateDTO tipoDocumentoUpdateDTO){
        return new ResponseEntity<>(TipoDocumentoService.actualizarTipoDocumento(tipoDocumentoUpdateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/tipoDocumentos/{tipoDocumentoId}")
    public ResponseEntity<String> eliminarTipoDocumento(@PathVariable("tipoDocumentoId") Integer tipoDocumentoId){
        return new ResponseEntity<>(TipoDocumentoService.eliminarTipoDocumento(tipoDocumentoId), HttpStatus.OK);
    }

}
