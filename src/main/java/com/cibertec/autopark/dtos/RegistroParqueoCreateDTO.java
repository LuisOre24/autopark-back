package com.cibertec.autopark.dtos;

import com.cibertec.autopark.model.Vehiculo;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class RegistroParqueoCreateDTO {

    private VehiculoDTO vehiculoDTO;

    private LocalDateTime horaFechaIngreso;

    private LocalDateTime horaFechaSalida;

    private Integer tiempoParqueo;

    private boolean estado;

}
