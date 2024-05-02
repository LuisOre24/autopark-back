package com.cibertec.autopark.mapper;

import com.cibertec.autopark.dtos.ParqueoCreateDTO;
import com.cibertec.autopark.dtos.ParqueoDTO;
import com.cibertec.autopark.dtos.ParqueoDetalleCreateDTO;
import com.cibertec.autopark.dtos.ParqueoDetalleDTO;
import com.cibertec.autopark.model.Parqueo;
import com.cibertec.autopark.model.ParqueoDetalle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ParqueoMapper {

    ParqueoMapper instancia= Mappers.getMapper(ParqueoMapper.class);

    @Mapping(target = "parqueoDetalleDTO", source = "parqueoDetalle",qualifiedByName ="mapParqueoDetalleToParqueoDetalleDTO" )
    @Mapping(target = "clienteDTO", source = "cliente") // Mapea el cliente
    @Mapping(target = "usuarioDTO", source = "usuario") // Mapea el cliente
    ParqueoDTO parqueoAParqueoDTO(Parqueo parqueo);


    @Named("mapParqueoDetalleToParqueoDetalleDTO" )
    default ParqueoDetalleDTO mapParqueoDetalleToParqueoDetalleDTO(ParqueoDetalle parqueoDetalle) {
        ParqueoDetalleDTO detalle = new ParqueoDetalleDTO();
        detalle.setId(parqueoDetalle.getId());
        detalle.setCantidad(parqueoDetalle.getCantidad());
        detalle.setPreciovta(parqueoDetalle.getPreciovta());
        detalle.setImporte(parqueoDetalle.getImporte());
        detalle.setVehiculoDTO(VehiculoMapper.instancia.vehiculoAVehiculoDTO(parqueoDetalle.getVehiculo()));
        return detalle;
    }


    @Mapping(target = "parqueoDetalleDTO", source = "parqueoDetalle", qualifiedByName ="mapParqueoDetalleToParqueoDetalleDTO" )
    @Mapping(target = "clienteDTO", source = "cliente")
    @Mapping(target = "usuarioDTO", source = "usuario")
    List<ParqueoDTO> listaParqueoAListaParqueoDTO (List<Parqueo> listaParqueo);

    @Mapping(target = "parqueoDetalle", source = "parqueoDetalleCreateDTO", qualifiedByName ="mapParqueoDetalleCreateDTOToParqueoDetalle" )
    @Mapping(target = "cliente", source = "clienteDTO")
    @Mapping(target = "usuario", source = "usuarioDTO")
    Parqueo parqueoCreateDTOAParqueo(ParqueoCreateDTO parqueoCreateDTO);

    @Named("mapParqueoDetalleCreateDTOToParqueoDetalle" )
    default ParqueoDetalle mapParqueoDetalleCreateDTOToParqueoDetalle(ParqueoDetalleCreateDTO detalleDTO) {
        ParqueoDetalle detalle = new ParqueoDetalle();
        detalle.setCantidad(detalleDTO.getCantidad());
        detalle.setPreciovta(detalleDTO.getPreciovta());
        detalle.setImporte(detalleDTO.getImporte());
        detalle.setVehiculo(VehiculoMapper.instancia.vehiculoDTOAVehiculo(detalleDTO.getVehiculoDTO()));
        return detalle;
    }
}
