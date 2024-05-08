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



    @Mapping(target = "parqueoDetalleDTO", source = "parqueoDetalle", qualifiedByName ="mapParqueoDetalleToParqueoDetalleDTO")
    @Mapping(target = "clienteDTO", source = "cliente")
    @Mapping(target = "usuarioDTO", source = "usuario")
    ParqueoDTO parqueoAParqueoDTO(Parqueo parqueo);

    @Named("mapParqueoDetalleToParqueoDetalleDTO" )
    default ParqueoDetalleDTO mapParqueoDetalleToParqueoDetalleDTO(ParqueoDetalle detalle) {
        ParqueoDetalleDTO detalleDTO = new ParqueoDetalleDTO();
        detalleDTO.setId(detalle.getId());
        detalleDTO.setCantidad(detalle.getCantidad());
        detalleDTO.setPreciovta(detalle.getPreciovta());
        detalleDTO.setImporte(detalle.getImporte());
        detalleDTO.setHoraingreso(detalle.getHoraingreso());
        detalleDTO.setHorasalida(detalle.getHorasalida());
        detalleDTO.setEstacionamientoDTO(EstacionamientoMapper.instancia.estacionamientoAEstacionamientoDTO(detalle.getEstacionamiento()));
        detalleDTO.setVehiculoDTO(VehiculoMapper.instancia.vehiculoAVehiculoDTO(detalle.getVehiculo()));
        return detalleDTO;
    }


    @Mapping(target = "parqueoDetalleDTO", source = "parqueoDetalle", qualifiedByName ="mapParqueoDetalleToParqueoDetalleDTO" )
    @Mapping(target = "clienteDTO", source = "cliente")
    @Mapping(target = "usuarioDTO", source = "usuario")
    List<ParqueoDTO> listaParqueoAListaParqueoDTO (List<Parqueo> listaParqueo);

    @Mapping(target = "parqueoDetalle", source = "parqueoDetalleDTO",qualifiedByName ="mapParqueoDetalleCreateDTOToParqueoDetalle" )
    @Mapping(target = "cliente", source = "clienteDTO") // Mapea el cliente
    @Mapping(target = "usuario", source = "usuarioDTO") // Mapea el cliente
    Parqueo parqueoCreateDTOAParqueo(ParqueoCreateDTO parqueoCreateDTO);


    @Named("mapParqueoDetalleCreateDTOToParqueoDetalle" )
    default ParqueoDetalle mapParqueoDetalleCreateDTOToParqueoDetalle(ParqueoDetalleCreateDTO parqueoDetalleCreateDTO) {
        ParqueoDetalle detalle = new ParqueoDetalle();
        detalle.setCantidad(parqueoDetalleCreateDTO.getCantidad());
        detalle.setPreciovta(parqueoDetalleCreateDTO.getPreciovta());
        detalle.setImporte(parqueoDetalleCreateDTO.getImporte());
        detalle.setHoraingreso(parqueoDetalleCreateDTO.getHoraingreso());
        detalle.setHorasalida(parqueoDetalleCreateDTO.getHorasalida());
        detalle.setEstacionamiento(EstacionamientoMapper.instancia.estacionamientoDTOAEstacionamiento(parqueoDetalleCreateDTO.getEstacionamiento()));
        detalle.setVehiculo(VehiculoMapper.instancia.vehiculoDTOAVehiculo(parqueoDetalleCreateDTO.getVehiculoDTO()));
        return detalle;
    }








//    @Named("mapParqueoDetalleDTOToParqueoDetalle" )
//    default ParqueoDetalle mapParqueoDetalleDTOToParqueoDetalle(ParqueoDetalleDTO detalleDTO) {
//        ParqueoDetalle detalle = new ParqueoDetalle();
//        detalle.setId(detalleDTO.getId());
//        detalle.setCantidad(detalleDTO.getCantidad());
//        detalle.setPreciovta(detalleDTO.getPreciovta());
//        detalle.setImporte(detalleDTO.getImporte());
//        detalle.setHoraingreso(detalleDTO.getHoraingreso());
//        detalle.setHorasalida(detalleDTO.getHorasalida());
//        detalle.setEstacionamiento(EstacionamientoMapper.instancia.estacionamientoDTOAEstacionamiento(detalleDTO.getEstacionamiento()));
//        detalle.setVehiculo(VehiculoMapper.instancia.vehiculoDTOAVehiculo(detalleDTO.getVehiculoDTO()));
//        return detalle;
//    }
}
