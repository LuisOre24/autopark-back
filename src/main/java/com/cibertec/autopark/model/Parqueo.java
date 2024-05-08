package com.cibertec.autopark.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="tb_parqueo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Parqueo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name="id_parqueo")
    private Long id;

    @Column(name="fechaParqueo", nullable = false)
    @Temporal(value= TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaParqueo;

    @ManyToOne()
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "parqueo")
    private List<ParqueoDetalle> parqueoDetalle;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

}
