package com.cibertec.autopark.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstacionamientoDTO {

    private Integer idEstacionamiento;
    private Integer codEstacionamiento;
    private String tipoEstacionamiento;
    private String nivel;
    private EstadoEstacionamientoDTO estado;

    public enum EstadoEstacionamientoDTO {
        DISPONIBLE,
        OCUPADO,
        RESERVADO,
        FUERA_DE_SERVICIO

    }
}
