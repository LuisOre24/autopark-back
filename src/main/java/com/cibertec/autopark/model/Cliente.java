package com.cibertec.autopark.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="tb_cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tipo_documento")
    private TipoDocumento tipoDocumento;

    @Column(length = 12, nullable = false)
    private String dni;

    @Column(length = 60, nullable = false)
    private String nombres;

    @Column(length = 200, nullable = false)
    private String apePaterno;

    @Column(length = 200, nullable = false)
    private String apeMaterno;

    @Column(length = 200, nullable = false)
    private String email;

}
