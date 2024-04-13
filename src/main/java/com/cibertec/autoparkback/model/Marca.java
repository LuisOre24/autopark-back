package com.cibertec.autoparkback.model;

import jakarta.persistence.*;

@Entity
@Table(name = "marca")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMarca;
    @Column(name = "descripcion", length = 50)
    private String descripcion;
    @Column(name = "estado")
    private boolean estado;

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

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
