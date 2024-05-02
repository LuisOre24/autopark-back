package com.cibertec.autopark.dtos;

import com.cibertec.autopark.model.Rol;
import com.cibertec.autopark.model.TipoDocumento;
import lombok.Data;

@Data
public class UsuarioCreateDTO {

    private String name;

    private String lastname;

    private TipoDocumentoDTO tipoDocumentoDTO;

    private String nroDocumento;

    private String correo;

    private String telefono;

    private Rol rol;

    private String username;

    private String password;

}
