package com.cibertec.autoparkback.service;

import com.cibertec.autoparkback.dto.UsuarioCreateDTO;
import com.cibertec.autoparkback.dto.UsuarioDTO;

import java.util.List;

public interface IUsuarioService {


    UsuarioDTO registrar(UsuarioCreateDTO entity);
    UsuarioDTO actualizar(UsuarioDTO entity);
    List<UsuarioDTO> listarTodo();
    UsuarioDTO listarUno(Integer id);
    void eliminar(Integer id);

}
