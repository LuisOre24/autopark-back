package com.cibertec.autopark.mapper;

import com.cibertec.autopark.dtos.MarcaCreateDTO;
import com.cibertec.autopark.dtos.MarcaDTO;
import com.cibertec.autopark.dtos.MarcaUpdateDTO;
import com.cibertec.autopark.model.Marca;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface MarcaMapper {
    MarcaMapper instancia = Mappers.getMapper(MarcaMapper.class);

    MarcaDTO marcaAMarcaDTO(Marca marca);
    Marca marcaDTOAMarca (MarcaDTO marcaDTO);
    Marca marcaCreateDTOAMarca (MarcaCreateDTO marcaCreateDTO);
    Marca marcaUpdateDTOAMarca (MarcaUpdateDTO marcaUpdateDTO);
    List<MarcaDTO> listarMarcaAListarMarcaDTO(List<Marca> listaMarca);
}
