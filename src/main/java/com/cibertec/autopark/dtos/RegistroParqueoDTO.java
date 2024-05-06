package com.cibertec.autopark.dtos;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class RegistroParqueoDTO {

    private Integer idParqueo;
    private VehiculoDTO vehiculoDTO;
    private LocalDateTime horaFechaIngreso;
    private LocalDateTime horaFechaSalida;
    private Integer tiempoParqueo;
    private boolean estado;

}
