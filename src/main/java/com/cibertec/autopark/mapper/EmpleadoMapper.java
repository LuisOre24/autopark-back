package com.cibertec.autopark.mapper;

import com.cibertec.autopark.dtos.EmpleadoCreateDTO;
import com.cibertec.autopark.dtos.EmpleadoDTO;
import com.cibertec.autopark.model.Empleado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


import java.util.List;
@Mapper
public interface EmpleadoMapper {
    EmpleadoMapper instancia = Mappers.getMapper(EmpleadoMapper.class);

    @Mapping(target = "tipoDocumentoDTO", source = "tipoDocumento")
    @Mapping(target = "rolDTO", source = "rol")
    EmpleadoDTO empleadoAEmpleadoDTO(Empleado empleado);

    @Mapping(target = "tipoDocumento", source = "tipoDocumentoDTO")
    @Mapping(target = "rol", source = "rolDTO")
    Empleado empleadoDTOAEnpleado (EmpleadoDTO empleadoDTO);

    @Mapping(target = "tipoDocumento", source = "tipoDocumentoDTO")
    @Mapping(target = "rol", source = "rolDTO")
    Empleado empleadoCreateDTOAEmpleado (EmpleadoCreateDTO empleadoCreateDTO);

    @Mapping(target = "tipoDocumento", source = "tipoDocumentoDTO")
    @Mapping(target = "rol", source = "rolDTO")
    Empleado empleadoUpdateDTOAEmpleado (EmpleadoDTO empleadoUpdateDTO);

    @Mapping(target = "tipoDocumentoDTO", source = "tipoDocumento")
    @Mapping(target = "rolDTO", source = "rol")
    List<EmpleadoDTO> listarEmpleadoAListarEmpleadoDTO(List<Empleado> listaEmpleado);
}
