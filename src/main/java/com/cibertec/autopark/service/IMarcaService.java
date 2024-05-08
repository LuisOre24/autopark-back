package com.cibertec.autopark.service;

import com.cibertec.autopark.dtos.MarcaCreateDTO;
import com.cibertec.autopark.dtos.MarcaDTO;
import com.cibertec.autopark.dtos.MarcaUpdateDTO;

import java.util.List;

public interface IMarcaService {

    List<MarcaDTO> listarMarcas();
    MarcaDTO obtenerMarcaPorId(Integer id);
    MarcaDTO registrarMarca(MarcaCreateDTO marcaCreateDTO);
    MarcaDTO actualizarMarca(MarcaUpdateDTO marcaUpdateDTO);
    String eliminarMarca(Integer id);
    String generarPdftoBase24();
}
