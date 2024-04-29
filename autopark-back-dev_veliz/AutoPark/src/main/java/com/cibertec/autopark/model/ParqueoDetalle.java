package com.cibertec.autopark.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name="tb_parqueoDetalle")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParqueoDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_parqueo")
    private Parqueo parqueo;


}
