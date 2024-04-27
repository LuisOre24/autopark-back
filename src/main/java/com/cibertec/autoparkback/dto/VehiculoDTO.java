package com.cibertec.autoparkback.dto;


public class VehiculoDTO {


    private Integer idVehiculo;
    private String placa;
    private TipoVehiculoDTO tipoVehiculoDTO;
    private String color;
    private MarcaDTO marcaDTO;

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public TipoVehiculoDTO getTipoVehiculo() {
        return tipoVehiculoDTO;
    }

    public void setTipoVehiculo(TipoVehiculoDTO tipoVehiculoDTO) {
        this.tipoVehiculoDTO = tipoVehiculoDTO;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public MarcaDTO getMarca() {
        return marcaDTO;
    }

    public void setMarca(MarcaDTO marcaDTO) {
        this.marcaDTO = marcaDTO;
    }
}
