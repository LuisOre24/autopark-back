package com.cibertec.autopark.dtos;

import lombok.Data;

@Data
public class TarifarioCreateDTO {

    private String descripcion;

    private TipoVehiculoDTO tipoVehiculoDTO;

    private double monto;

}
