package com.cibertec.autopark.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class RegistroParqueoCreateDTO {

    private VehiculoDTO vehiculoDTO;

    private LocalDateTime horaFechaIngreso;

    private LocalDateTime horaFechaSalida;

    private Integer tiempoParqueo;

    private boolean estado;

}
