package com.cibertec.autoparkback.mapper;

import com.cibertec.autoparkback.dto.ParqueoCreateDTO;
import com.cibertec.autoparkback.dto.ParqueoDTO;
import com.cibertec.autoparkback.model.Parqueo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import java.util.List;


@Mapper
public interface ParqueoMapper {

    ParqueoMapper instance = Mappers.getMapper(ParqueoMapper.class);

    ParqueoDTO parqueoToParqueoDTO(Parqueo parqueo);
    Parqueo parqueoDTOToParqueo(ParqueoDTO parqueoDTO);
    Parqueo parqueoCrearDTOToParqueo( ParqueoCreateDTO parqueoCreateDTO);
    Parqueo parqueoActualizarDTOToParqueo(ParqueoDTO parqueoDTO);
    List<ParqueoDTO> listarParqueosToParqueoDTO(List<Parqueo> parqueos);

}
