package com.cibertec.autopark.service;

import com.cibertec.autopark.dtos.TipoDocumentoCreateDTO;
import com.cibertec.autopark.dtos.TipoDocumentoDTO;
import com.cibertec.autopark.dtos.TipoDocumentoUpdateDTO;

import java.util.List;

public interface ITipoDocumentoService {

    List<TipoDocumentoDTO> listarTipoDocumentos();
    TipoDocumentoDTO obtenerTipoDocumentoPorId(Integer id);
    TipoDocumentoDTO registrarTipoDocumento(TipoDocumentoCreateDTO rolCreateDTO);
    TipoDocumentoDTO actualizarTipoDocumento(TipoDocumentoUpdateDTO rolUpdateDTO);
    String eliminarTipoDocumento(Integer id);

}
