package com.cibertec.autopark.controller;

import com.cibertec.autopark.dtos.UsuarioCreateDTO;
import com.cibertec.autopark.dtos.UsuarioDTO;
import com.cibertec.autopark.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
    private IUsuarioService IUsuarioService;

    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios(){
        return new ResponseEntity<>(IUsuarioService.listarUsuarios(), HttpStatus.OK);
    }

    @GetMapping("/usuarios/{usuarioId}")
    public ResponseEntity<UsuarioDTO> obtenerUsuarioPorId(@PathVariable("usuarioId") Integer usuarioId){
        return new ResponseEntity<>(IUsuarioService.obtenerUsuarioPorId(usuarioId), HttpStatus.OK);
    }

    @PostMapping("usuarios")
    public ResponseEntity<UsuarioDTO> registrarUsuario(@RequestBody UsuarioCreateDTO usuarioCreateDTO){
        return new ResponseEntity<>(IUsuarioService.registrarUsuario(usuarioCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("usuarios")
    public ResponseEntity<UsuarioDTO> actualizarUsuario(@RequestBody UsuarioDTO usuarioUpdateDTO){
        return new ResponseEntity<>(IUsuarioService.actualizarUsuario(usuarioUpdateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/usuarios/{usuarioId}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable("usuarioId") Integer usuarioId){
        String text = IUsuarioService.eliminarUsuario(usuarioId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
