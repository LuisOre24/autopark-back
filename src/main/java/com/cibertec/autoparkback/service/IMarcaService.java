package com.cibertec.autoparkback.service;

import com.cibertec.autoparkback.dto.MarcaCreateDTO;
import com.cibertec.autoparkback.dto.MarcaDTO;

import java.util.List;

public interface IMarcaService{


    MarcaDTO registrar(MarcaCreateDTO entity);
    MarcaDTO actualizar(MarcaDTO entity);
    List<MarcaDTO> listarTodo();
    MarcaDTO listarUno(Integer id);
    void eliminar(Integer id);

}
