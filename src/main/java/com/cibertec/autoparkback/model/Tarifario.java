package com.cibertec.autoparkback.model;

import jakarta.persistence.*;

public class Tarifario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idtarifa;

    @Column(name = "descripcion", length = 50, nullable = false)
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "id_tipo_vehiculo", nullable = false)
    private TipoVehiculo tipoVehiculo;
    @Column(name = "monto", precision = 2, nullable = false)
    private double monto;

    public Integer getIdtarifa() {
        return idtarifa;
    }

    public void setIdtarifa(Integer idtarifa) {
        this.idtarifa = idtarifa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
