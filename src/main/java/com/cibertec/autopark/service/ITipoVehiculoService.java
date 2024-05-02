package com.cibertec.autopark.service;

import com.cibertec.autopark.dtos.TipoVehiculoCreateDTO;
import com.cibertec.autopark.dtos.TipoVehiculoDTO;
import com.cibertec.autopark.dtos.TipoVehiculoUpdateDTO;

import java.util.List;

public interface ITipoVehiculoService {
    List<TipoVehiculoDTO> listarTipoVehiculos();
    TipoVehiculoDTO obtenerTipoVehiculoPorId(Integer id);
    TipoVehiculoDTO registrarTipoVehiculo(TipoVehiculoCreateDTO tipoVehiculoCreateDTO);
    TipoVehiculoDTO actualizarTipoVehiculo(TipoVehiculoUpdateDTO tipoVehiculoUpdateDTO);
    String eliminarTipoVehiculo (Integer id);
}
