package com.cibertec.autoparkback.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_vehiculo")
public class TipoVehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoVehiculo;
    @Column(name = "descripcion", length = 50)
    private String descipcion;
    @Column(name = "estado")
    private boolean estado;

    public Integer getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(Integer idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
