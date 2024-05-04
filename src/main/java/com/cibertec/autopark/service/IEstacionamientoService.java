package com.cibertec.autopark.service;

import com.cibertec.autopark.dtos.EstacionamientoCreateDTO;
import com.cibertec.autopark.dtos.EstacionamientoDTO;
import com.cibertec.autopark.dtos.EstacionamientoUpdateDTO;

import java.util.List;

public interface IEstacionamientoService {

    List<EstacionamientoDTO> listarEstacionamientos();
    EstacionamientoDTO obtenerEstacionamientoPorId(Integer id);
    EstacionamientoDTO registrarEstacionamiento(EstacionamientoCreateDTO estacionamientoCreateDTO);
    EstacionamientoDTO actualizarEstacionamiento(EstacionamientoUpdateDTO estacionamientoUpdateDTO);
    String eliminarEstacionamiento(Integer id);
    
}
