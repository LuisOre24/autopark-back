package com.cibertec.autoparkback.mapper;

import com.cibertec.autoparkback.dto.EstacionamientoCreateDTO;
import com.cibertec.autoparkback.dto.EstacionamientoDTO;
import com.cibertec.autoparkback.model.Estacionamiento;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import java.util.List;


@Mapper
public interface EstacionamientoMapper {

    EstacionamientoMapper instance = Mappers.getMapper(EstacionamientoMapper.class);

    EstacionamientoDTO estacionamientoToEstacionamientoDTO(Estacionamiento estacionamiento);
    Estacionamiento estacionamientoDTOToEstacionamiento(EstacionamientoDTO estacionamientoDTO);
    Estacionamiento estacionamientoCrearDTOToEstacionamiento( EstacionamientoCreateDTO estacionamientoCreateDTO);
    Estacionamiento estacionamientoActualizarDTOToEstacionamiento(EstacionamientoDTO estacionamientoDTO);
    List<EstacionamientoDTO> listarEstacionamientosToEstacionamientoDTO(List<Estacionamiento> estacionamientos);

}
