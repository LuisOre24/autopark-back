package com.cibertec.autopark.mapper;

import com.cibertec.autopark.dtos.RegistroParqueoCreateDTO;
import com.cibertec.autopark.dtos.RegistroParqueoDTO;
import com.cibertec.autopark.model.RegistroParqueo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RegistroParqueoMapper {

    RegistroParqueoMapper instancia = Mappers.getMapper(RegistroParqueoMapper.class);

    @Mapping(target = "vehiculoDTO", source = "vehiculo")
    RegistroParqueoDTO registroParqueoARegistroParqueoDTO(RegistroParqueo registroParqueo);

    @Mapping(target = "vehiculo", source = "vehiculoDTO")
    RegistroParqueo registroParqueoDTOARegistroParqueo(RegistroParqueoDTO registroParqueoDTO);

    @Mapping(target = "vehiculo", source = "vehiculoDTO")
    RegistroParqueo registroParqueoCreateDTOARegistroParqueo(RegistroParqueoCreateDTO registroParqueoCreateDTO);

    @Mapping(target = "vehiculoDTO", source = "vehiculo")
    List<RegistroParqueoDTO> listaRegistroParqueoAListaRegistroParqueoDTO (List<RegistroParqueo> listaRegistroParqueo);


}
