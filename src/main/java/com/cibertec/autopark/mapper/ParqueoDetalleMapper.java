package com.cibertec.autopark.mapper;


import com.cibertec.autopark.dtos.ParqueoDetalleCreateDTO;
import com.cibertec.autopark.dtos.ParqueoDetalleDTO;

import com.cibertec.autopark.model.ParqueoDetalle;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ParqueoDetalleMapper {

    ParqueoDetalleMapper instancia = Mappers.getMapper(ParqueoDetalleMapper.class);


    @Mapping(target = "vehiculoDTO", source = "vehiculo")
    List<ParqueoDetalleDTO> listaParqueoDetalleAListaParqueoDetalleDTO (List<ParqueoDetalle> listaParqueoDetalle);

    @Mapping(target = "vehiculo", source = "vehiculoDTO")
    ParqueoDetalle parqueoDetalleDTOTOAParqueoDetalle(ParqueoDetalleDTO pedDetalleDTO);

    @Mapping(target = "vehiculoDTO", source = "vehiculo")
    ParqueoDetalleDTO parqueoDetalleTOAParqueoDetalle(ParqueoDetalle pedDetalle);

    @Mapping(target = "vehiculo", source = "vehiculoDTO")
    ParqueoDetalle parqueoDetalleCreateDTOTAParqueoDetalle(ParqueoDetalleCreateDTO parqueoDetalleCreateDTO);
}
