package com.cibertec.autoparkback.service;

import com.cibertec.autoparkback.dto.RolCreateDTO;
import com.cibertec.autoparkback.dto.RolDTO;

import java.util.List;

public interface IRolService {


    RolDTO registrar(RolCreateDTO entity);
    RolDTO actualizar(RolDTO entity);
    List<RolDTO> listarTodo();
    RolDTO listarUno(Integer id);
    void eliminar(Integer id);

}
