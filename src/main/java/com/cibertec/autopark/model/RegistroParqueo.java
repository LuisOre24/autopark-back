package com.cibertec.autopark.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDateTime;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_registro_parqueo")
public class RegistroParqueo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRegistroParqueo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehiculo")
    private Vehiculo vehiculo;

    @Column(nullable = false)
    /*@DateTimeFormat(pattern = "HH:mm")*/
    private LocalDateTime horaFechaIngreso;

    @Column(nullable = true)
    /*@DateTimeFormat(pattern = "HH:mm")*/
    private LocalDateTime horaFechaSalida;

    @Column(name = "tiempo_parqueo")
    private Integer tiempoParqueo;

    @Column(name = "estado")
    private boolean estado;

}
