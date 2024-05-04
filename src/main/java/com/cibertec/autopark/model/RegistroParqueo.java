package com.cibertec.autopark.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_registro_parqueo")
public class RegistroParqueo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRegistroParqueo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehiculo")
    private Vehiculo vehiculo;

    @Column(nullable = false)
    private LocalDateTime horaFechaIngreso;

    @Column(nullable = true)
    private LocalDateTime horaFechaSalida;

    @Column(name = "tiempo_parqueo")
    private Integer tiempoParqueo;

    @Column(name = "estado")
    private boolean estado;

}
