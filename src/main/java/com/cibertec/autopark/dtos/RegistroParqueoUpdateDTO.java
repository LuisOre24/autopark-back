package com.cibertec.autopark.dtos;


import lombok.Data;

import java.time.LocalDateTime;


@Data
public class RegistroParqueoUpdateDTO {

    private Integer idParqueo;

    private LocalDateTime horaFechaSalida;


}
