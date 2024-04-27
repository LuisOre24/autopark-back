package com.cibertec.autoparkback.dto;


public class TipoVehiculoCreateDTO {



    private String descripcion;
    private boolean estado;


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
