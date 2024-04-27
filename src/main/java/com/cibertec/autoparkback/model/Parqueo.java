package com.cibertec.autoparkback.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "parqueos")
public class Parqueo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idParqueo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehiculo", nullable = false)
    private Vehiculo vehiculo;
    @Column(nullable = false)
    private LocalDateTime horaFechaIngreso;
    @Column(nullable = true)
    private LocalDateTime horaFechaSalida;
    @Column(name = "estado")
    private boolean estado;

    public Integer getIdParqueo() {
        return idParqueo;
    }

    public void setIdParqueo(Integer idParqueo) {
        this.idParqueo = idParqueo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
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
