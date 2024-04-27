package com.cibertec.autoparkback.mapper;

import com.cibertec.autoparkback.dto.VehiculoCreateDTO;
import com.cibertec.autoparkback.dto.VehiculoDTO;
import com.cibertec.autoparkback.model.Vehiculo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import java.util.List;


@Mapper
public interface VehiculoMapper {

    VehiculoMapper instance = Mappers.getMapper(VehiculoMapper.class);

    VehiculoDTO vehiculoToVehiculoDTO(Vehiculo vehiculo);
    Vehiculo vehiculoDTOToVehiculo(VehiculoDTO vehiculoDTO);
    Vehiculo vehiculoCrearDTOToVehiculo( VehiculoCreateDTO vehiculoCreateDTO);
    Vehiculo vehiculoActualizarDTOToVehiculo(VehiculoDTO vehiculoDTO);
    List<VehiculoDTO> listarVehiculosToVehiculoDTO(List<Vehiculo> vehiculos);

}
