package com.cibertec.autopark.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="tb_parqueoDetalle")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParqueoDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name="id_parqueo_detalle")
    private Long id;

    @ManyToOne()
    @JoinColumn(name="id_vehiculo")
    private Vehiculo vehiculo;

    @Column(nullable = false)
    private Long cantidad;

    @Column(nullable = false)
    private BigDecimal preciovta;

    @Column(nullable = false)
    private BigDecimal importe;

    @Column(nullable = false)
    @Temporal(value= TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    private Date horaingreso;

    @Column(nullable = false)
    @Temporal(value= TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    private Date horasalida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_parqueo")
    private Parqueo parqueo;


}
