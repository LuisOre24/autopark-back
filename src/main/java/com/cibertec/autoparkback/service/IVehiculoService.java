package com.cibertec.autoparkback.service;

import com.cibertec.autoparkback.dto.VehiculoCreateDTO;
import com.cibertec.autoparkback.dto.VehiculoDTO;

import java.util.List;

public interface IVehiculoService{

    VehiculoDTO registrar(VehiculoCreateDTO entity);
    VehiculoDTO actualizar(VehiculoDTO entity);
    List<VehiculoDTO> listarTodo();
    VehiculoDTO listarUno(Integer id);
    void eliminar(Integer id);

}
