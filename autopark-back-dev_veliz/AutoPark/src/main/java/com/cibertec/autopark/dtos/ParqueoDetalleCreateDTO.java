package com.cibertec.autopark.dtos;

import com.cibertec.autopark.model.Parqueo;
import com.cibertec.autopark.model.Vehiculo;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class ParqueoDetalleCreateDTO {

    private VehiculoDTO vehiculoDTO;
    private Long cantidad;
    private BigDecimal preciovta;
    private BigDecimal importe;

}
