package com.cibertec.autopark.mapper;

import com.cibertec.autopark.dtos.VehiculoCreateDTO;
import com.cibertec.autopark.dtos.VehiculoDTO;
import com.cibertec.autopark.dtos.VehiculoUpdateDTO;
import com.cibertec.autopark.model.Vehiculo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VehiculoMapper {

    VehiculoMapper instancia= Mappers.getMapper(VehiculoMapper.class);

    @Mapping(target = "tipoVehiculoDTO", source = "tipoVehiculo")
    @Mapping(target = "marcaDTO", source = "marca")
    @Mapping(target = "clienteDTO", source = "cliente")
    VehiculoDTO vehiculoAVehiculoDTO(Vehiculo vehiculo);

    Vehiculo vehiculoDTOAVehiculo(VehiculoDTO vehiculoDTO);

    @Mapping(target = "tipoVehiculo", source = "tipoVehiculoDTO")
    @Mapping(target="marca", source = "marcaDTO")
    @Mapping(target="cliente", source = "clienteDTO")
    Vehiculo vehiculoCreateDTOAVehiculo(VehiculoCreateDTO vehiculoCreateDTO);

    @Mapping(target="tipoVehiculo", source = "tipoVehiculoDTO")
    @Mapping(target="marca", source = "marcaDTO")
    @Mapping(target ="cliente", source = "clienteDTO")
    Vehiculo vehiculoUpdateDTOAVehiculo(VehiculoUpdateDTO vehiculoUpdateDTO);

    @Mapping(target = "tipoVehiculoDTO", source = "tipoVehiculo")
    @Mapping(target = "marcaDTO", source = "marca")
    @Mapping(target = "clienteDTO", source = "cliente")
    List<VehiculoDTO> listaVehiculoAListaVehiculoDTO (List<Vehiculo> listaVehiculo);

}
