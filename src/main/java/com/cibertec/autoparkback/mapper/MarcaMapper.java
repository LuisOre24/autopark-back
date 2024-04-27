package com.cibertec.autoparkback.mapper;

import com.cibertec.autoparkback.dto.MarcaCreateDTO;
import com.cibertec.autoparkback.dto.MarcaDTO;
import com.cibertec.autoparkback.model.Marca;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import java.util.List;


@Mapper
public interface MarcaMapper {

    MarcaMapper instance = Mappers.getMapper(MarcaMapper.class);

    MarcaDTO marcaToMarcaDTO(Marca marca);
    Marca marcaDTOToMarca(MarcaDTO marcaDTO);
    Marca marcaCrearDTOToMarca( MarcaCreateDTO marcaCreateDTO);
    Marca marcaActualizarDTOToMarca(MarcaDTO marcaDTO);
    List<MarcaDTO> listarMarcasToMarcaDTO(List<Marca> marcas);

}
