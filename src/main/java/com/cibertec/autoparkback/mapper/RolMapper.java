package com.cibertec.autoparkback.mapper;

import com.cibertec.autoparkback.dto.RolCreateDTO;
import com.cibertec.autoparkback.dto.RolDTO;
import com.cibertec.autoparkback.model.Rol;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import java.util.List;


@Mapper
public interface RolMapper {

    RolMapper instance = Mappers.getMapper(RolMapper.class);

    RolDTO rolToRolDTO(Rol rol);
    Rol rolDTOToRol(RolDTO rolDTO);
    Rol rolCrearDTOToRol( RolCreateDTO rolCreateDTO);
    Rol rolActualizarDTOToRol(RolDTO rolDTO);
    List<RolDTO> listarRolesToRolDTO(List<Rol> roles);

}
