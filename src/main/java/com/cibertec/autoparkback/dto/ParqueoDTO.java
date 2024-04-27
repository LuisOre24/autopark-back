package com.cibertec.autoparkback.dto;


import com.cibertec.autoparkback.model.Vehiculo;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class ParqueoDTO {

    private Integer idParqueo;
    private VehiculoDTO vehiculo;
    private LocalDateTime horaFechaIngreso;
    private LocalDateTime horaFechaSalida;
    private boolean estado;


    public Integer getIdParqueo() {
        return idParqueo;
    }

    public void setIdParqueo(Integer idParqueo) {
        this.idParqueo = idParqueo;
    }

    public VehiculoDTO getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoDTO vehiculo) {
        this.vehiculo = vehiculo;
    }

    public LocalDateTime getHoraFechaIngreso() {
        return horaFechaIngreso;
    }

    public void setHoraFechaIngreso(LocalDateTime horaFechaIngreso) {
        this.horaFechaIngreso = horaFechaIngreso;
    }

    public LocalDateTime getHoraFechaSalida() {
        return horaFechaSalida;
    }

    public void setHoraFechaSalida(LocalDateTime horaFechaSalida) {
        this.horaFechaSalida = horaFechaSalida;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
