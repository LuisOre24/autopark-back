package com.cibertec.autopark.dtos;

import com.cibertec.autopark.model.Estacionamiento;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class ParqueoDetalleCreateDTO {

    private VehiculoDTO vehiculoDTO;
    private Long cantidad;
    private BigDecimal preciovta;
    private BigDecimal importe;
    private Date horaingreso;
    private Date horasalida;
    private Estacionamiento estacionamiento;

}
