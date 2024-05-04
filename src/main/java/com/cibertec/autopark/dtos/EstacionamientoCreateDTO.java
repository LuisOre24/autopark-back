package com.cibertec.autopark.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstacionamientoCreateDTO {

    private Integer codEstacionamiento;

    private String tipoEstacionamiento;

    private String nivel;

    private EstadoEstacionamientoCreateDTO estado;

    public enum EstadoEstacionamientoCreateDTO {
        DISPONIBLE,
        OCUPADO,
        RESERVADO,
        FUERA_DE_SERVICIO

    }
}
