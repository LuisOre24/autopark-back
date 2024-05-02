package com.cibertec.autopark.service;

import com.cibertec.autopark.dtos.RegistroParqueoCreateDTO;
import com.cibertec.autopark.dtos.RegistroParqueoDTO;

import java.util.List;

public interface IRegistroParqueoService {

    List<RegistroParqueoDTO> listarRegistroParqueos();
    RegistroParqueoDTO obtenerRegistroParqueoPorId(Integer id);
    RegistroParqueoDTO registrarRegistroParqueo(RegistroParqueoCreateDTO registroParqueoCreateDTO);
    RegistroParqueoDTO actualizarRegistroParqueo(RegistroParqueoDTO registroParqueoUpdateDTO);
    String eliminarRegistroParqueo(Integer id);
}
