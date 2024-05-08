package com.cibertec.autopark.service;

import com.cibertec.autopark.dtos.UsuarioCreateDTO;
import com.cibertec.autopark.dtos.UsuarioDTO;

import java.util.List;

public interface IUsuarioService {

    List<UsuarioDTO> listarUsuarios();
    UsuarioDTO obtenerUsuarioPorId(Integer id);
    UsuarioDTO registrarUsuario(UsuarioCreateDTO usuarioCreateDTO);
    UsuarioDTO actualizarUsuario(UsuarioDTO usuarioUpdateDTO);
    String eliminarUsuario(Integer id);
    UsuarioDTO usuarioPorUser(String usuario);
}
