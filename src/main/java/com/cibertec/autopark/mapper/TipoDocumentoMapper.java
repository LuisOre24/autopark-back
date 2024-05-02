package com.cibertec.autopark.mapper;

import com.cibertec.autopark.dtos.TipoDocumentoCreateDTO;
import com.cibertec.autopark.dtos.TipoDocumentoDTO;
import com.cibertec.autopark.dtos.TipoDocumentoUpdateDTO;
import com.cibertec.autopark.model.TipoDocumento;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TipoDocumentoMapper {

    TipoDocumentoMapper instancia = Mappers.getMapper(TipoDocumentoMapper.class);

    TipoDocumentoDTO tipoDocumentoATipoDocumentoDTO(TipoDocumento tipoDocumento);
    TipoDocumento tipoDocumentoDTOATipoDocumento(TipoDocumentoDTO tipoDocumentoDTO);
    TipoDocumento tipoDocumentoCrearDTOATipoDocumento( TipoDocumentoCreateDTO tipoDocumentoCreateDTO);
    TipoDocumento tipoDocumentoUpdateDTOATipoDocumento(TipoDocumentoUpdateDTO tipoDocumentoUpdateDTO);
    List<TipoDocumentoDTO> listarTipoDocumentoATipoDocumentoDTO(List<TipoDocumento> listaTipoDocumentos);
}
