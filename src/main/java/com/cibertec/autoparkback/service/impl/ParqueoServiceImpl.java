package com.cibertec.autoparkback.service.impl;

import com.cibertec.autoparkback.dto.ParqueoCreateDTO;
import com.cibertec.autoparkback.dto.ParqueoDTO;
import com.cibertec.autoparkback.mapper.ParqueoMapper;
import com.cibertec.autoparkback.model.Parqueo;
import com.cibertec.autoparkback.repository.IParqueoRepository;
import com.cibertec.autoparkback.service.IParqueoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParqueoServiceImpl implements IParqueoService {

    @Autowired
    private IParqueoRepository repository;

    @Override
    public ParqueoDTO registrar(ParqueoCreateDTO entity) {
        Parqueo parqueo = ParqueoMapper.instance.parqueoCrearDTOToParqueo(entity);
        return ParqueoMapper.instance.parqueoToParqueoDTO(repository.save(parqueo));
    }

    @Override
    public ParqueoDTO actualizar(ParqueoDTO entity) {
        Parqueo parqueo = ParqueoMapper.instance.parqueoDTOToParqueo(entity);
        return ParqueoMapper.instance.parqueoToParqueoDTO(repository.save(parqueo));
    }

    @Override
    public List<ParqueoDTO> listarTodo() {
        return ParqueoMapper.instance.listarParqueosToParqueoDTO(repository.findAll());
    }

    @Override
    public ParqueoDTO listarUno(Integer id) {
        Optional<Parqueo> parqueo = repository.findById(id);
        return parqueo.map( ParqueoMapper.instance :: parqueoToParqueoDTO).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        Optional<Parqueo> parqueo = repository.findById(id);
        if(parqueo.isPresent()){
            repository.deleteById(id);
        }
    }
}
