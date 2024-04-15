package com.cibertec.autoparkback.model;

import jakarta.persistence.*;

import javax.naming.Name;

@Entity
@Table(name = "estacionamientos")
public class Estacionamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="Id Estacionamiento")
    private Integer idEstacionamiento;

    @Column(name="Codigo de Estacionamiento")
    private Integer codEstacionamiento;

    @Column(name="Tipo de estacionamiento")
    private String tipoEstacionamiento;

    @Column(name="Nivel")
    private String nivel;

    @Column(name="Codigo de Estacionamiento")
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
