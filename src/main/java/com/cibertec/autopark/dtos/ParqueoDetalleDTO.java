package com.cibertec.autopark.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class ParqueoDetalleDTO {

    private Long id;
    private VehiculoDTO vehiculoDTO;
    private Long cantidad;
    private BigDecimal preciovta;
    private BigDecimal importe;
    private Date horaingreso;
    private Date horasalida;

}
