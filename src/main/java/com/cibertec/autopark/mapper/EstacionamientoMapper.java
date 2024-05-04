package com.cibertec.autopark.mapper;

import com.cibertec.autopark.dtos.EstacionamientoCreateDTO;
import com.cibertec.autopark.dtos.EstacionamientoDTO;
import com.cibertec.autopark.dtos.EstacionamientoUpdateDTO;
import com.cibertec.autopark.model.Estacionamiento;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EstacionamientoMapper {
    EstacionamientoMapper instancia = Mappers.getMapper(EstacionamientoMapper.class);

    EstacionamientoDTO estacionamientoAEstacionamientoDTO(Estacionamiento estacionamiento);
    Estacionamiento estacionamientoDTOAEstacionamiento (EstacionamientoDTO estacionamientoDTO);
    Estacionamiento estacionamientoCreateDTOAEstacionamiento (EstacionamientoCreateDTO estacionamientoCreateDTO);
    Estacionamiento estacionamientoUpdateDTOAEstacionamiento (EstacionamientoUpdateDTO estacionamientoUpdateDTO);
    List<EstacionamientoDTO> listarEstacionamientoAListarEstacionamientoDTO(List<Estacionamiento> listaEstacionamiento);
}
