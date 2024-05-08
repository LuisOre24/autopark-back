package com.cibertec.autopark.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
public class ParqueoDTO {
    private Long id;
    private Date fechaParqueo;
    private ClienteDTO clienteDTO;
    private UsuarioDTO usuarioDTO;
    private List<ParqueoDetalleDTO> parqueoDetalleDTO;
}
