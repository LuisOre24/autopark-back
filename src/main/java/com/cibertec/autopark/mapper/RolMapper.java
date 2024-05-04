package com.cibertec.autopark.mapper;

import com.cibertec.autopark.dtos.RolCreateDTO;
import com.cibertec.autopark.dtos.RolDTO;
import com.cibertec.autopark.model.Rol;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RolMapper {
    RolMapper instancia = Mappers.getMapper(RolMapper.class);

    RolDTO rolARolDTO(Rol rol);
    Rol rolDTOARol (RolDTO rolDTO);
    Rol rolCreateDTOARol (RolCreateDTO rolCreateDTO);
    Rol rolUpdateDTOARol (RolDTO rolUpdateDTO);
    List<RolDTO> listarRolAListarRolDTO(List<Rol> listaRol);
}
