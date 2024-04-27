package com.cibertec.autoparkback.dto;


import com.cibertec.autoparkback.model.Estacionamiento;

public class EstacionamientoCreateDTO {

    private Integer codEstacionamiento;

    private String tipoEstacionamiento;

    private String nivel;

    private Estacionamiento.EstadoEstacionamiento estado;

    public enum EstadoEstacionamiento {
        DISPONIBLE,
        OCUPADO,
        RESERVADO,
        FUERA_DE_SERVICIO

    }

    public Integer getCodEstacionamiento() {
        return codEstacionamiento;
    }

    public void setCodEstacionamiento(Integer codEstacionamiento) {
        this.codEstacionamiento = codEstacionamiento;
    }

    public String getTipoEstacionamiento() {
        return tipoEstacionamiento;
    }

    public void setTipoEstacionamiento(String tipoEstacionamiento) {
        this.tipoEstacionamiento = tipoEstacionamiento;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Estacionamiento.EstadoEstacionamiento getEstado() {
        return estado;
    }

    public void setEstado(Estacionamiento.EstadoEstacionamiento estado) {
        this.estado = estado;
    }
}
