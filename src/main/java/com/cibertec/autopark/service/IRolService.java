package com.cibertec.autopark.service;

import com.cibertec.autopark.dtos.RolCreateDTO;
import com.cibertec.autopark.dtos.RolDTO;

import java.util.List;

public interface IRolService {

    List<RolDTO> listarRoles();
    RolDTO obtenerRolPorId(Integer id);
    RolDTO registrarRol(RolCreateDTO rolCreateDTO);
    RolDTO actualizarRol(RolDTO rolUpdateDTO);
    String eliminarRol(Integer id);
    
}
