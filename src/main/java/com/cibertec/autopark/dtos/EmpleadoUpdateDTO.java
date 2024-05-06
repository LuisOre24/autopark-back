package com.cibertec.autopark.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpleadoUpdateDTO {
    private Integer idEmpleado;
    private String name;
    private String lastname;
    private TipoDocumentoDTO tipoDocumentoDTO;
    private String nroDocumento;
    private String correo;
    private String telefono;
    private RolDTO rolDTO;
}
