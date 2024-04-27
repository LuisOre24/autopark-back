package com.cibertec.autoparkback.mapper;

import com.cibertec.autoparkback.dto.TipoVehiculoCreateDTO;
import com.cibertec.autoparkback.dto.TipoVehiculoDTO;
import com.cibertec.autoparkback.model.TipoVehiculo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import java.util.List;


@Mapper
public interface TipoVehiculoMapper {

    TipoVehiculoMapper instance = Mappers.getMapper(TipoVehiculoMapper.class);

    TipoVehiculoDTO tipoVehiculoToTipoVehiculoDTO(TipoVehiculo tipoVehiculo);
    TipoVehiculo tipoVehiculoDTOToTipoVehiculo(TipoVehiculoDTO tipoVehiculoDTO);
    TipoVehiculo tipoVehiculoCrearDTOToTipoVehiculo( TipoVehiculoCreateDTO tipoVehiculoCreateDTO);
    TipoVehiculo tipoVehiculoActualizarDTOToTipoVehiculo(TipoVehiculoDTO tipoVehiculoDTO);
    List<TipoVehiculoDTO> listarTipoVehiculosToTipoVehiculoDTO(List<TipoVehiculo> tipoVehiculos);

}
