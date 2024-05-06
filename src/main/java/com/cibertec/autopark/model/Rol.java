package com.cibertec.autopark.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;

    @Column(name = "role", nullable = false, length = 20, unique = true)
    private String role;
    private boolean status;

}
