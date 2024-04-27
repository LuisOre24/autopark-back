package com.cibertec.autoparkback.service;

import com.cibertec.autoparkback.dto.EstacionamientoCreateDTO;
import com.cibertec.autoparkback.dto.EstacionamientoDTO;

import java.util.List;

public interface IEstacionamientoService {


    EstacionamientoDTO registrar(EstacionamientoCreateDTO entity);
    EstacionamientoDTO actualizar(EstacionamientoDTO entity);
    List<EstacionamientoDTO> listarTodo();
    EstacionamientoDTO listarUno(Integer id);
    void eliminar(Integer id);

}
