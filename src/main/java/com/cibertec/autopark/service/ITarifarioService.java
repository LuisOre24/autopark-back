package com.cibertec.autopark.service;

import com.cibertec.autopark.dtos.TarifarioCreateDTO;
import com.cibertec.autopark.dtos.TarifarioDTO;

import java.util.List;

public interface ITarifarioService {

    List<TarifarioDTO> listarTarifarios();
    TarifarioDTO obtenerTarifarioPorId(Integer id);
    TarifarioDTO registrarTarifario(TarifarioCreateDTO tarifarioCreateDTO);
    TarifarioDTO actualizarTarifario(TarifarioDTO tarifarioUpdateDTO);
    String eliminarTarifario(Integer id);
    TarifarioDTO tarifaPorTVehiculo(Integer id);
    String generarPdftoBase24();
    
}
