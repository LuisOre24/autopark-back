package com.cibertec.autoparkback.service.impl;

import com.cibertec.autoparkback.dto.UsuarioCreateDTO;
import com.cibertec.autoparkback.dto.UsuarioDTO;
import com.cibertec.autoparkback.mapper.UsuarioMapper;
import com.cibertec.autoparkback.model.Usuario;
import com.cibertec.autoparkback.repository.IUsuarioRepository;
import com.cibertec.autoparkback.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepository repository;

    @Override
    public UsuarioDTO registrar(UsuarioCreateDTO entity) {
        Usuario usuario = UsuarioMapper.instance.usuarioCrearDTOToUsuario(entity);
        return UsuarioMapper.instance.usuarioToUsuarioDTO(repository.save(usuario));
    }

    @Override
    public UsuarioDTO actualizar(UsuarioDTO entity) {
        Usuario usuario = UsuarioMapper.instance.usuarioDTOToUsuario(entity);
        return UsuarioMapper.instance.usuarioToUsuarioDTO(repository.save(usuario));
    }

    @Override
    public List<UsuarioDTO> listarTodo() {
        return UsuarioMapper.instance.listarUsuariosToUsuarioDTO(repository.findAll());
    }

    @Override
    public UsuarioDTO listarUno(Integer id) {
        Optional<Usuario> usuario = repository.findById(id);
        return usuario.map( UsuarioMapper.instance :: usuarioToUsuarioDTO).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        Optional<Usuario> usuario = repository.findById(id);
        if(usuario.isPresent()){
            repository.deleteById(id);
        }
    }
}
