package com.cibertec.autopark.mapper;

import com.cibertec.autopark.dtos.TipoVehiculoCreateDTO;
import com.cibertec.autopark.dtos.TipoVehiculoDTO;
import com.cibertec.autopark.dtos.TipoVehiculoUpdateDTO;
import com.cibertec.autopark.model.TipoVehiculo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-29T02:50:23-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
public class TipoVehiculoMapperImpl implements TipoVehiculoMapper {

    @Override
    public TipoVehiculoDTO tipoVehiculoATipoVehiculoDTO(TipoVehiculo tipoVehiculo) {
        if ( tipoVehiculo == null ) {
            return null;
        }

        TipoVehiculoDTO tipoVehiculoDTO = new TipoVehiculoDTO();

        tipoVehiculoDTO.setId( tipoVehiculo.getId() );
        tipoVehiculoDTO.setDes_tipoVehiculo( tipoVehiculo.getDes_tipoVehiculo() );

        return tipoVehiculoDTO;
    }

    @Override
    public TipoVehiculo tipoVehiculoDTOATipoVehiculo(TipoVehiculoDTO tipoVehiculoDTO) {
        if ( tipoVehiculoDTO == null ) {
            return null;
        }

        TipoVehiculo tipoVehiculo = new TipoVehiculo();

        tipoVehiculo.setId( tipoVehiculoDTO.getId() );
        tipoVehiculo.setDes_tipoVehiculo( tipoVehiculoDTO.getDes_tipoVehiculo() );

        return tipoVehiculo;
    }

    @Override
    public TipoVehiculo tipoVehiculoCrearDTOATipoVehiculo(TipoVehiculoCreateDTO tipoVehiculoCreateDTO) {
        if ( tipoVehiculoCreateDTO == null ) {
            return null;
        }

        TipoVehiculo tipoVehiculo = new TipoVehiculo();

        tipoVehiculo.setDes_tipoVehiculo( tipoVehiculoCreateDTO.getDes_tipoVehiculo() );

        return tipoVehiculo;
    }

    @Override
    public TipoVehiculo tipoVehiculoUpdateDTOATipoVehiculo(TipoVehiculoUpdateDTO tipoVehiculoUpdateDTO) {
        if ( tipoVehiculoUpdateDTO == null ) {
            return null;
        }

        TipoVehiculo tipoVehiculo = new TipoVehiculo();

        tipoVehiculo.setId( tipoVehiculoUpdateDTO.getId() );
        tipoVehiculo.setDes_tipoVehiculo( tipoVehiculoUpdateDTO.getDes_tipoVehiculo() );

        return tipoVehiculo;
    }

    @Override
    public List<TipoVehiculoDTO> listarTipoVehiculoATipoVehiculoDTO(List<TipoVehiculo> listaTipoVehiculos) {
        if ( listaTipoVehiculos == null ) {
            return null;
        }

        List<TipoVehiculoDTO> list = new ArrayList<TipoVehiculoDTO>( listaTipoVehiculos.size() );
        for ( TipoVehiculo tipoVehiculo : listaTipoVehiculos ) {
            list.add( tipoVehiculoATipoVehiculoDTO( tipoVehiculo ) );
        }

        return list;
    }
}
