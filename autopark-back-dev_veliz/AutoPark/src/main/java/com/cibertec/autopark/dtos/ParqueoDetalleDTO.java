package com.cibertec.autopark.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class ParqueoDetalleDTO {

    private Long id;
    private VehiculoDTO vehiculoDTO;
    private Long cantidad;
    private BigDecimal preciovta;
    private BigDecimal importe;

}
