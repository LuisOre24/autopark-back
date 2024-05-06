package com.cibertec.autopark.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehiculoDTO {

    private Integer id_vehiculo;
    private String placa;
    private String color;

    private TipoVehiculoDTO tipoVehiculoDTO;
    private MarcaDTO marcaDTO;
    private ClienteDTO clienteDTO;
}
