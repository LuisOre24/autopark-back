package com.cibertec.autopark.mapper;

import com.cibertec.autopark.dtos.ParqueoDetalleCreateDTO;
import com.cibertec.autopark.dtos.ParqueoDetalleDTO;
import com.cibertec.autopark.model.ParqueoDetalle;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-29T02:50:23-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
public class ParqueoDetalleMapperImpl implements ParqueoDetalleMapper {

    @Override
    public List<ParqueoDetalleDTO> listaParqueoDetalleAListaParqueoDetalleDTO(List<ParqueoDetalle> listaParqueoDetalle) {
        if ( listaParqueoDetalle == null ) {
            return null;
        }

        List<ParqueoDetalleDTO> list = new ArrayList<ParqueoDetalleDTO>( listaParqueoDetalle.size() );
        for ( ParqueoDetalle parqueoDetalle : listaParqueoDetalle ) {
            list.add( parqueoDetalleToParqueoDetalleDTO( parqueoDetalle ) );
        }

        return list;
    }

    @Override
    public ParqueoDetalle parqueoDetalleCreateDTOAParqueoDetalle(ParqueoDetalleCreateDTO pedDetalleCreateDTO) {
        if ( pedDetalleCreateDTO == null ) {
            return null;
        }

        ParqueoDetalle parqueoDetalle = new ParqueoDetalle();

        parqueoDetalle.setCantidad( pedDetalleCreateDTO.getCantidad() );
        parqueoDetalle.setPreciovta( pedDetalleCreateDTO.getPreciovta() );
        parqueoDetalle.setImporte( pedDetalleCreateDTO.getImporte() );

        return parqueoDetalle;
    }

    protected ParqueoDetalleDTO parqueoDetalleToParqueoDetalleDTO(ParqueoDetalle parqueoDetalle) {
        if ( parqueoDetalle == null ) {
            return null;
        }

        ParqueoDetalleDTO parqueoDetalleDTO = new ParqueoDetalleDTO();

        parqueoDetalleDTO.setId( parqueoDetalle.getId() );
        parqueoDetalleDTO.setCantidad( parqueoDetalle.getCantidad() );
        parqueoDetalleDTO.setPreciovta( parqueoDetalle.getPreciovta() );
        parqueoDetalleDTO.setImporte( parqueoDetalle.getImporte() );

        return parqueoDetalleDTO;
    }
}
