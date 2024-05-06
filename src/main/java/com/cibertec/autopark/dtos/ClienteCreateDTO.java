package com.cibertec.autopark.dtos;

import com.cibertec.autopark.model.TipoDocumento;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteCreateDTO {
    private String dni;
    private TipoDocumentoDTO tipoDocumentoDTO;
    private String nombres;
    private String apePaterno;
    private String apeMaterno;
    private String email;
}
