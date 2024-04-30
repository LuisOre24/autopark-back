package com.cibertec.autopark.dtos;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoVehiculoDTO {

    private Integer id;
    private String des_tipoVehiculo;

}