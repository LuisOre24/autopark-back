package com.cibertec.autopark.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_estacionamiento")
public class Estacionamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_estacionamiento")
    private Integer idEstacionamiento;

    @Column(name="cod_estacionamiento", unique = true)
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

}
