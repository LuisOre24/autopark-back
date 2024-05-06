package com.cibertec.autopark.dtos;

import lombok.Data;

@Data
public class TarifarioDTO {

    private Integer idtarifa;

    private String descripcion;

    private TipoVehiculoDTO tipoVehiculoDTO;

    private double monto;

}
