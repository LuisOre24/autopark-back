package com.cibertec.autopark.service;

import com.cibertec.autopark.dtos.*;
import com.cibertec.autopark.mapper.RolMapper;
import com.cibertec.autopark.model.Rol;
import com.cibertec.autopark.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RolServiceImpl implements IRolService{


    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<RolDTO> listarRoles() {
        return RolMapper.instancia.listarRolAListarRolDTO(rolRepository.findAll());
    }

    @Override
    public RolDTO obtenerRolPorId(Integer id) {
        Optional<Rol> rolOptinal = rolRepository.findById(id);
        return rolOptinal.map(RolMapper.instancia::rolARolDTO).orElse(null);
    }

    @Override
    public RolDTO registrarRol(RolCreateDTO rolCreateDTO) {
        Rol rol = RolMapper.instancia.rolCreateDTOARol(rolCreateDTO);
        Rol respuestaEntity=rolRepository.save(rol);
        return RolMapper.instancia.rolARolDTO(respuestaEntity);
    }

    @Override
    public RolDTO actualizarRol(RolDTO rolUpdateDTO) {
        Rol rol = RolMapper.instancia.rolUpdateDTOARol(rolUpdateDTO);
        Rol respuestaEntity=rolRepository.save(rol);
        return RolMapper.instancia.rolARolDTO(respuestaEntity);
    }

    @Override
    public String eliminarRol(Integer id) {
        Optional<Rol> rolOptional =rolRepository.findById(id);
        if(rolOptional.isPresent()){
            rolRepository.delete(rolOptional.get());
            return "Registro eliminado";
        }else{
            throw new NoSuchElementException("No se pudo realizar la eliminacion por Id");
        }
    }
}
