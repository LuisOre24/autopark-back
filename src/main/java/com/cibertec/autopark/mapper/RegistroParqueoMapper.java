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
    @Mapping(target = "vehiculoDTO.tipoVehiculoDTO", source = "vehiculo.tipoVehiculo")
    @Mapping(target = "vehiculoDTO.marcaDTO", source = "vehiculo.marca")
    @Mapping(target = "vehiculoDTO.clienteDTO", source = "vehiculo.cliente")
    RegistroParqueoDTO registroParqueoARegistroParqueoDTO(RegistroParqueo registroParqueo);

    @Mapping(target = "vehiculo", source = "vehiculoDTO")
    @Mapping(target = "vehiculo.tipoVehiculo", source = "vehiculoDTO.tipoVehiculoDTO")
    @Mapping(target = "vehiculo.marca", source = "vehiculoDTO.marcaDTO")
    @Mapping(target = "vehiculo.cliente", source = "vehiculoDTO.clienteDTO")
    RegistroParqueo registroParqueoDTOARegistroParqueo(RegistroParqueoDTO registroParqueoDTO);

    @Mapping(target = "vehiculo", source = "vehiculoDTO")
    @Mapping(target = "vehiculo.tipoVehiculo", source = "vehiculoDTO.tipoVehiculoDTO")
    @Mapping(target = "vehiculo.marca", source = "vehiculoDTO.marcaDTO")
    @Mapping(target = "vehiculo.cliente", source = "vehiculoDTO.clienteDTO")
    RegistroParqueo registroParqueoCreateDTOARegistroParqueo(RegistroParqueoCreateDTO registroParqueoCreateDTO);

    @Mapping(target = "vehiculoDTO", source = "vehiculo")
    @Mapping(target = "vehiculoDTO.tipoVehiculoDTO", source = "vehiculo.tipoVehiculo")
    @Mapping(target = "vehiculoDTO.marcaDTO", source = "vehiculo.marca")
    @Mapping(target = "vehiculoDTO.clienteDTO", source = "vehiculo.cliente")
    List<RegistroParqueoDTO> listaRegistroParqueoAListaRegistroParqueoDTO (List<RegistroParqueo> listaRegistroParqueo);


}
