package com.cibertec.autopark.service;

import com.cibertec.autopark.dtos.UsuarioCreateDTO;
import com.cibertec.autopark.dtos.UsuarioDTO;
import com.cibertec.autopark.mapper.UsuarioMapper;
import com.cibertec.autopark.model.Usuario;
import com.cibertec.autopark.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UsuarioDTO> listarUsuarios() {
        return UsuarioMapper.instancia.listarUsuarioAListarUsuarioDTO(usuarioRepository.findAll());
    }

    @Override
    public UsuarioDTO obtenerUsuarioPorId(Integer id) {
        Optional<Usuario> usuarioOptinal = usuarioRepository.findById(id);
        return usuarioOptinal.map(UsuarioMapper.instancia::usuarioAUsuarioDTO).orElse(null);
    }

    @Override
    public UsuarioDTO registrarUsuario(UsuarioCreateDTO usuarioCreateDTO) {
        Usuario usuario = UsuarioMapper.instancia.usuarioCreateDTOAUsuario(usuarioCreateDTO);
        //Usuario newUser = new Usuario();
        //newUser.setName(usuario.getName());
        //newUser.setLastname((usuario.getLastname()));
        //newUser.setCorreo(usuario.getCorreo());
        //newUser.setTelefono(usuario.getTelefono());
        //newUser.setTipoDocumento(usuario.getTipoDocumento());
        //newUser.setNroDocumento(usuario.getNroDocumento());
        //newUser.setUsername(usuario.getUsername());
        //newUser.setPassword(passwordEncoder.encode(usuario.getPassword()));
        System.out.println(passwordEncoder.encode(usuario.getPassword()));
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        Usuario respuestaEntity=usuarioRepository.save(usuario);
        System.out.println("entra en registrar");
        return UsuarioMapper.instancia.usuarioAUsuarioDTO(respuestaEntity);
    }

    @Override
    public UsuarioDTO actualizarUsuario(UsuarioDTO usuarioUpdateDTO) {
        Usuario usuario = UsuarioMapper.instancia.usuarioUpdateDTOAUsuario(usuarioUpdateDTO);
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        Usuario respuestaEntity=usuarioRepository.save(usuario);
        System.out.println("entra en actualizar");
        return UsuarioMapper.instancia.usuarioAUsuarioDTO(respuestaEntity);
    }

    @Override
    public String eliminarUsuario(Integer id) {
        Optional<Usuario> usuarioOptional =usuarioRepository.findById(id);
        if(usuarioOptional.isPresent()){
            usuarioRepository.delete(usuarioOptional.get());
            return "Registro eliminado";
        }else{
            throw new NoSuchElementException("No se pudo realizar la eliminacion por Id");
        }
    }
    
}
