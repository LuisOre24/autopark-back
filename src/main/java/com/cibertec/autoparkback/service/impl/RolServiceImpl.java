package com.cibertec.autoparkback.service.impl;

import com.cibertec.autoparkback.dto.RolCreateDTO;
import com.cibertec.autoparkback.dto.RolDTO;
import com.cibertec.autoparkback.mapper.RolMapper;
import com.cibertec.autoparkback.model.Rol;
import com.cibertec.autoparkback.repository.IRolRepository;
import com.cibertec.autoparkback.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements IRolService {

    @Autowired
    private IRolRepository repository;

    @Override
    public RolDTO registrar(RolCreateDTO entity) {
        Rol rol = RolMapper.instance.rolCrearDTOToRol(entity);
        return RolMapper.instance.rolToRolDTO(repository.save(rol));
    }

    @Override
    public RolDTO actualizar(RolDTO entity) {
        Rol rol = RolMapper.instance.rolDTOToRol(entity);
        return RolMapper.instance.rolToRolDTO(repository.save(rol));
    }

    @Override
    public List<RolDTO> listarTodo() {
        return RolMapper.instance.listarRolesToRolDTO(repository.findAll());
    }

    @Override
    public RolDTO listarUno(Integer id) {
        Optional<Rol> rol = repository.findById(id);
        return rol.map( RolMapper.instance :: rolToRolDTO).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        Optional<Rol> rol = repository.findById(id);
        if(rol.isPresent()){
            repository.deleteById(id);
        }
    }
}
