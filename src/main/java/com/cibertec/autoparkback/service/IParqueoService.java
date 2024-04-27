package com.cibertec.autoparkback.service;

import com.cibertec.autoparkback.dto.ParqueoCreateDTO;
import com.cibertec.autoparkback.dto.ParqueoDTO;

import java.util.List;

public interface IParqueoService {


    ParqueoDTO registrar(ParqueoCreateDTO entity);
    ParqueoDTO actualizar(ParqueoDTO entity);
    List<ParqueoDTO> listarTodo();
    ParqueoDTO listarUno(Integer id);
    void eliminar(Integer id);

}
