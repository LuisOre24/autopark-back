package com.cibertec.autopark.dtos;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class RegistroParqueoUpdateDTO {

    private Integer idRegistroParqueo;

    private LocalDateTime horaFechaSalida;


}
