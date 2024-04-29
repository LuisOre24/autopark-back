package com.cibertec.autopark.dtos;

import com.cibertec.autopark.model.Cliente;
import com.cibertec.autopark.model.ParqueoDetalle;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class ParqueoDTO {
    private Long id;
    private Date fechaParqueo;
    private ClienteDTO clienteDTO;
    private Set<ParqueoDetalleDTO> parqueoDetalleDTO;
}
