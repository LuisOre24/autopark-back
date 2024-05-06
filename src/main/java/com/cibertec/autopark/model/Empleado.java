package com.cibertec.autopark.model;

import jakarta.persistence.*;
import lombok.*;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @Entity
    @Table(name = "tb_empleado")
    public class Empleado {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idEmpleado;

        private String name;

        private String lastname;

        @ManyToOne
        @JoinColumn(name = "tipo_documento")
        private TipoDocumento tipoDocumento;

        @Column(name = "nro_documento", nullable = false, unique = true)
        private String nroDocumento;

        private String correo;

        private String telefono;

        @ManyToOne
        @JoinColumn(name = "id_rol")
        private Rol rol;
}
