package com.cibertec.autopark.controller;

import com.cibertec.autopark.dtos.TipoDocumentoCreateDTO;
import com.cibertec.autopark.dtos.TipoDocumentoDTO;
import com.cibertec.autopark.dtos.TipoDocumentoUpdateDTO;
import com.cibertec.autopark.service.ITipoDocumentoService;
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
    private ITipoDocumentoService ITipoDocumentoService;

    @GetMapping("/tipodocumentos")
    public ResponseEntity<List<TipoDocumentoDTO>> listarTipoDocumentos(){
        return new ResponseEntity<>(ITipoDocumentoService.listarTipoDocumentos(), HttpStatus.OK);
    }

    @GetMapping("/tipodocumentos/{tipoDocumentoId}")
    public ResponseEntity<TipoDocumentoDTO> obtenerTipoDocumentoPorId(@PathVariable("tipoDocumentoId") Integer tipoDocumentoId){
        return new ResponseEntity<>(ITipoDocumentoService.obtenerTipoDocumentoPorId(tipoDocumentoId), HttpStatus.OK);
    }

    @PostMapping("tipodocumentos")
    public ResponseEntity<TipoDocumentoDTO> registrarTipoDocumento(@RequestBody TipoDocumentoCreateDTO tipoDocumentoCreateDTO){
        return new ResponseEntity<>(ITipoDocumentoService.registrarTipoDocumento(tipoDocumentoCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("tipodocumentos")
    public ResponseEntity<TipoDocumentoDTO> actualizarTipoDocumento(@RequestBody TipoDocumentoUpdateDTO tipoDocumentoUpdateDTO){
        return new ResponseEntity<>(ITipoDocumentoService.actualizarTipoDocumento(tipoDocumentoUpdateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/tipodocumentos/{tipoDocumentoId}")
    public ResponseEntity<?> eliminarTipoDocumento(@PathVariable("tipoDocumentoId") Integer tipoDocumentoId){
        String text = ITipoDocumentoService.eliminarTipoDocumento(tipoDocumentoId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
