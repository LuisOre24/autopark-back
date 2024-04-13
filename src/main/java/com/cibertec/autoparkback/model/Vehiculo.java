package com.cibertec.autoparkback.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVehiculo;
    @Column(name = "placa", length = 8)
    private String placa;
    @ManyToOne
    @JoinColumn(name = "id_tipo_vehiculo")
    private TipoVehiculo tipoVehiculo;
    @Column(name = "color")
    private String color;
    @ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca marca;

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
