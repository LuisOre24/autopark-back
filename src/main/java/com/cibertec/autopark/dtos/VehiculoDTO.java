package com.cibertec.autopark.dtos;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class VehiculoDTO {

    private Integer id;
    private String placa;
    private String color;

   private TipoVehiculoDTO tipoVehiculoDTO;
    private MarcaDTO marcaDTO;
}
