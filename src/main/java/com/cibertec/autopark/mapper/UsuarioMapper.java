package com.cibertec.autopark.mapper;

import com.cibertec.autopark.dtos.UsuarioCreateDTO;
import com.cibertec.autopark.dtos.UsuarioDTO;
import com.cibertec.autopark.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper instancia = Mappers.getMapper(UsuarioMapper.class);

    @Mapping(target = "tipoDocumentoDTO", source = "tipoDocumento")
    @Mapping(target = "rolDTO", source = "rol")
    UsuarioDTO usuarioAUsuarioDTO(Usuario usuario);

    @Mapping(target = "tipoDocumento", source = "tipoDocumentoDTO")
    @Mapping(target = "rol", source = "rolDTO")
    Usuario usuarioDTOAUsuario (UsuarioDTO usuarioDTO);

    @Mapping(target = "tipoDocumento", source = "tipoDocumentoDTO")
    @Mapping(target = "rol", source = "rolDTO")
    Usuario usuarioCreateDTOAUsuario (UsuarioCreateDTO usuarioCreateDTO);

    @Mapping(target = "tipoDocumento", source = "tipoDocumentoDTO")
    @Mapping(target = "rol", source = "rolDTO")
    Usuario usuarioUpdateDTOAUsuario (UsuarioDTO usuarioUpdateDTO);

    @Mapping(target = "tipoDocumentoDTO", source = "tipoDocumento")
    @Mapping(target = "rolDTO", source = "rol")
    List<UsuarioDTO> listarUsuarioAListarUsuarioDTO(List<Usuario> listaUsuario);
    
}
