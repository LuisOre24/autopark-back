package com.cibertec.autopark.dtos;

import com.cibertec.autopark.model.Estacionamiento;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
public class ParqueoDetalleDTO {

    private Long id;
    private VehiculoDTO vehiculoDTO;
    private Long cantidad;
    private BigDecimal preciovta;
    private BigDecimal importe;
    private Date horaingreso;
    private Date horasalida;
    private EstacionamientoDTO estacionamientoDTO;

}
