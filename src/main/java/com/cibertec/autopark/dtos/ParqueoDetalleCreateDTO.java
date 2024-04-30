package com.cibertec.autopark.dtos;

import com.cibertec.autopark.model.Parqueo;
import com.cibertec.autopark.model.Vehiculo;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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

}
