package com.cibertec.autopark.mapper;

import com.cibertec.autopark.dtos.TipoVehiculoCreateDTO;
import com.cibertec.autopark.dtos.TipoVehiculoDTO;
import com.cibertec.autopark.dtos.TipoVehiculoUpdateDTO;
import com.cibertec.autopark.model.TipoVehiculo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface TipoVehiculoMapper {

    TipoVehiculoMapper instancia = Mappers.getMapper(TipoVehiculoMapper.class);

    TipoVehiculoDTO tipoVehiculoATipoVehiculoDTO(TipoVehiculo tipoVehiculo);
    TipoVehiculo tipoVehiculoDTOATipoVehiculo(TipoVehiculoDTO tipoVehiculoDTO);
    TipoVehiculo tipoVehiculoCrearDTOATipoVehiculo( TipoVehiculoCreateDTO tipoVehiculoCreateDTO);
    TipoVehiculo tipoVehiculoUpdateDTOATipoVehiculo(TipoVehiculoUpdateDTO tipoVehiculoUpdateDTO);
    List<TipoVehiculoDTO> listarTipoVehiculoATipoVehiculoDTO(List<TipoVehiculo> listaTipoVehiculos);
}
