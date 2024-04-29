package com.cibertec.autopark.service;

import com.cibertec.autopark.dtos.ParqueoCreateDTO;
import com.cibertec.autopark.dtos.ParqueoDTO;
import com.cibertec.autopark.dtos.ParqueoResponseDTO;

import java.util.List;

public interface ParqueoService {

    List<ParqueoDTO>  listarParqueos();
    ParqueoDTO obtenerParqueoPorID(long id);
    ParqueoResponseDTO registrarParqueo(ParqueoCreateDTO parqueoCreateDTO);
}

