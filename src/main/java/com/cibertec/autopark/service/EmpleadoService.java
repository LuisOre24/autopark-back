package com.cibertec.autopark.service;

import com.cibertec.autopark.dtos.EmpleadoCreateDTO;
import com.cibertec.autopark.dtos.EmpleadoDTO;
import com.cibertec.autopark.model.Empleado;

import java.util.List;
import java.util.Optional;


public interface EmpleadoService {
    List<EmpleadoDTO> listarEmpleados();
    EmpleadoDTO obtenerEmpleadoPorId(Integer id);
    EmpleadoDTO registrarEmpleado(EmpleadoCreateDTO empleadoCreateDTO);
    EmpleadoDTO actualizarEmpleado(EmpleadoDTO empleadoUpdateDTO);
    String eliminarEmpleado(Integer id);

}
