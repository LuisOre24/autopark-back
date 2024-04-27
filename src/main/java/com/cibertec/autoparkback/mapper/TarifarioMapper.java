package com.cibertec.autoparkback.mapper;

import com.cibertec.autoparkback.dto.TarifarioCreateDTO;
import com.cibertec.autoparkback.dto.TarifarioDTO;
import com.cibertec.autoparkback.model.Tarifario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import java.util.List;


@Mapper
public interface TarifarioMapper {

    TarifarioMapper instance = Mappers.getMapper(TarifarioMapper.class);

    TarifarioDTO tarifarioToTarifarioDTO(Tarifario tarifario);
    Tarifario tarifarioDTOToTarifario(TarifarioDTO tarifarioDTO);
    Tarifario tarifarioCrearDTOToTarifario( TarifarioCreateDTO tarifarioCreateDTO);
    Tarifario tarifarioActualizarDTOToTarifario(TarifarioDTO tarifarioDTO);
    List<TarifarioDTO> listarTarifariosToTarifarioDTO(List<Tarifario> tarifarios);

}
