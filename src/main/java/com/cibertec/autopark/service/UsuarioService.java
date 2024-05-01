package com.cibertec.autopark.service;

import com.cibertec.autopark.jwt.JwtResponse;
import com.cibertec.autopark.dtos.LoginRequest;

import com.cibertec.autopark.jwt.JwtUtil;
import com.cibertec.autopark.repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtil jwtUtil;

    private final AuthenticationManager authenticationManager;

    public JwtResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=usuarioRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtUtil.getToken(user);
        return JwtResponse.builder()
                .jwtToken(token)
                .build();

    }

}
