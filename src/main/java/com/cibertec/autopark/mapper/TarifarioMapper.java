package com.cibertec.autopark.mapper;

import com.cibertec.autopark.dtos.TarifarioCreateDTO;
import com.cibertec.autopark.dtos.TarifarioDTO;
import com.cibertec.autopark.model.Tarifario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TarifarioMapper {
    TarifarioMapper instancia = Mappers.getMapper(TarifarioMapper.class);

    @Mapping(target = "tipoVehiculoDTO", source = "tipoVehiculo")
    TarifarioDTO TarifarioATarifarioDTO(Tarifario tarifario);
    @Mapping(target = "tipoVehiculo", source = "tipoVehiculoDTO")
    Tarifario TarifarioDTOATarifario (TarifarioDTO tarifarioDTO);
    @Mapping(target = "tipoVehiculo", source = "tipoVehiculoDTO")
    Tarifario TarifarioCreateDTOATarifario (TarifarioCreateDTO tarifarioCreateDTO);
    @Mapping(target = "tipoVehiculo", source = "tipoVehiculoDTO")
    Tarifario TarifarioUpdateDTOATarifario (TarifarioDTO TarifarioUpdateDTO);
    @Mapping(target = "tipoVehiculoDTO", source = "tipoVehiculo")
    List<TarifarioDTO> listarTarifarioAListarTarifarioDTO(List<Tarifario> listaTarifario);
}
