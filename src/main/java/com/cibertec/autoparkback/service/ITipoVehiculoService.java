package com.cibertec.autoparkback.service;

import com.cibertec.autoparkback.dto.TipoVehiculoCreateDTO;
import com.cibertec.autoparkback.dto.TipoVehiculoDTO;

import java.util.List;

public interface ITipoVehiculoService{

    TipoVehiculoDTO registrar(TipoVehiculoCreateDTO entity);
    TipoVehiculoDTO actualizar(TipoVehiculoDTO entity);
    List<TipoVehiculoDTO> listarTodo();
    TipoVehiculoDTO listarUno(Integer id);
    void eliminar(Integer id);

}
