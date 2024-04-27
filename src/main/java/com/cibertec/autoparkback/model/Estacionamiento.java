package com.cibertec.autoparkback.model;

import jakarta.persistence.*;

import javax.naming.Name;

@Entity
@Table(name = "estacionamientos")
public class Estacionamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_estacionamiento")
    private Integer idEstacionamiento;

    @Column(name="codigo_estacionamiento")
    private Integer codEstacionamiento;

    @Column(name="tipo_estacionamiento")
    private String tipoEstacionamiento;

    @Column(name="nivel")
    private String nivel;

    @Column(name="estado")
    private EstadoEstacionamiento estado;

    public enum EstadoEstacionamiento {
        DISPONIBLE,
        OCUPADO,
        RESERVADO,
        FUERA_DE_SERVICIO

    }


    //GETTER AND SETTER
    // Getters y setters
    public Integer getIdEstacionamiento() {
        return idEstacionamiento;
    }

    public void setIdEstacionamiento(Integer idEstacionamiento) {
        this.idEstacionamiento = idEstacionamiento;
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

    public EstadoEstacionamiento getEstado() {
        return estado;
    }

    public void setEstado(EstadoEstacionamiento estado) {
        this.estado = estado;
    }


}
