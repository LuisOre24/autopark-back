package com.cibertec.autopark.controller;

import com.cibertec.autopark.jwt.JwtResponse;
import com.cibertec.autopark.dtos.LoginRequest;
import com.cibertec.autopark.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private UsuarioService authService;

    @GetMapping("/login")
    public String login(){
        return "Login";
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> Authenticate(@RequestBody LoginRequest loginRequest){
        return new ResponseEntity<JwtResponse>(authService.login(loginRequest), HttpStatus.OK);
    }

    @PostMapping("/register")
    public String register(){
        return "register";
    }

}
