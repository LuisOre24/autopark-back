package com.cibertec.autoparkback.dto;

import com.cibertec.autoparkback.model.TipoVehiculo;
import jakarta.persistence.*;

public class TarifarioDTO {

    private Integer idtarifa;
    private String descripcion;
    private TipoVehiculoDTO tipoVehiculo;
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

    public TipoVehiculoDTO getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculoDTO tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
