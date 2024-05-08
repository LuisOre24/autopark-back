package com.cibertec.autopark.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_tarifario")
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


}
