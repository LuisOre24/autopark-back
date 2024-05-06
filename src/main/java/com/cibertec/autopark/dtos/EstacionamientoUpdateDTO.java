package com.cibertec.autopark.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstacionamientoUpdateDTO {

    private Integer idEstacionamiento;
    private Integer codEstacionamiento;
    private String tipoEstacionamiento;
    private String nivel;
    private EstadoEstacionamientoUpdateDTO estado;
    public enum EstadoEstacionamientoUpdateDTO {
        DISPONIBLE,
        OCUPADO,
        RESERVADO,
        FUERA_DE_SERVICIO

    }
}