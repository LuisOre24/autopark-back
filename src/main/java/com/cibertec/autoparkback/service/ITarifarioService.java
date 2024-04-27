package com.cibertec.autoparkback.service;

import com.cibertec.autoparkback.dto.TarifarioCreateDTO;
import com.cibertec.autoparkback.dto.TarifarioDTO;

import java.util.List;

public interface ITarifarioService{

    TarifarioDTO registrar(TarifarioCreateDTO entity);
    TarifarioDTO actualizar(TarifarioDTO entity);
    List<TarifarioDTO> listarTodo();
    TarifarioDTO listarUno(Integer id);
    void eliminar(Integer id);

}
