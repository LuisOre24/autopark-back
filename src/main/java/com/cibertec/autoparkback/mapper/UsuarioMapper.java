package com.cibertec.autoparkback.mapper;

import com.cibertec.autoparkback.dto.UsuarioCreateDTO;
import com.cibertec.autoparkback.dto.UsuarioDTO;
import com.cibertec.autoparkback.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import java.util.List;


@Mapper
public interface UsuarioMapper {

    UsuarioMapper instance = Mappers.getMapper(UsuarioMapper.class);

    UsuarioDTO usuarioToUsuarioDTO(Usuario usuario);
    Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO);
    Usuario usuarioCrearDTOToUsuario( UsuarioCreateDTO usuarioCreateDTO);
    Usuario usuarioActualizarDTOToUsuario(UsuarioDTO usuarioDTO);
    List<UsuarioDTO> listarUsuariosToUsuarioDTO(List<Usuario> usuarios);

}
