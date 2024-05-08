package com.cibertec.autopark.mapper;

import com.cibertec.autopark.dtos.MarcaCreateDTO;
import com.cibertec.autopark.dtos.MarcaDTO;
import com.cibertec.autopark.dtos.MarcaUpdateDTO;
import com.cibertec.autopark.model.Marca;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-08T03:24:22-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Eclipse Adoptium)"
)
public class MarcaMapperImpl implements MarcaMapper {

    @Override
    public MarcaDTO marcaAMarcaDTO(Marca marca) {
        if ( marca == null ) {
            return null;
        }

        MarcaDTO marcaDTO = new MarcaDTO();

        marcaDTO.setId( marca.getId() );
        marcaDTO.setDes_marca( marca.getDes_marca() );

        return marcaDTO;
    }

    @Override
    public Marca marcaDTOAMarca(MarcaDTO marcaDTO) {
        if ( marcaDTO == null ) {
            return null;
        }

        Marca marca = new Marca();

        marca.setId( marcaDTO.getId() );
        marca.setDes_marca( marcaDTO.getDes_marca() );

        return marca;
    }

    @Override
    public Marca marcaCreateDTOAMarca(MarcaCreateDTO marcaCreateDTO) {
        if ( marcaCreateDTO == null ) {
            return null;
        }

        Marca marca = new Marca();

        marca.setDes_marca( marcaCreateDTO.getDes_marca() );

        return marca;
    }

    @Override
    public Marca marcaUpdateDTOAMarca(MarcaUpdateDTO marcaUpdateDTO) {
        if ( marcaUpdateDTO == null ) {
            return null;
        }

        Marca marca = new Marca();

        marca.setId( marcaUpdateDTO.getId() );
        marca.setDes_marca( marcaUpdateDTO.getDes_marca() );

        return marca;
    }

    @Override
    public List<MarcaDTO> listarMarcaAListarMarcaDTO(List<Marca> listaMarca) {
        if ( listaMarca == null ) {
            return null;
        }

        List<MarcaDTO> list = new ArrayList<MarcaDTO>( listaMarca.size() );
        for ( Marca marca : listaMarca ) {
            list.add( marcaAMarcaDTO( marca ) );
        }

        return list;
    }
}
