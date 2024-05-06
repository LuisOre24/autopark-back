package com.cibertec.autopark.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class ParqueoDTO {
    private Long id;
    private Date fechaParqueo;
    private ClienteDTO clienteDTO;
   private EmpleadoDTO empleadoDTO;
    private Set<ParqueoDetalleDTO> parqueoDetalleDTO;
}
