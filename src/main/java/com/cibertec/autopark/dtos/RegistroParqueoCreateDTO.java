package com.cibertec.autopark.dtos;

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