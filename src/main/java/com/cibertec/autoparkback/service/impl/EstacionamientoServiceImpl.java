package com.cibertec.autoparkback.service.impl;

import com.cibertec.autoparkback.dto.EstacionamientoCreateDTO;
import com.cibertec.autoparkback.dto.EstacionamientoDTO;
import com.cibertec.autoparkback.mapper.EstacionamientoMapper;
import com.cibertec.autoparkback.model.Estacionamiento;
import com.cibertec.autoparkback.repository.IEstacionamientoRepository;
import com.cibertec.autoparkback.service.IEstacionamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstacionamientoServiceImpl implements IEstacionamientoService {

    @Autowired
    private IEstacionamientoRepository repository;

    @Override
    public EstacionamientoDTO registrar(EstacionamientoCreateDTO entity) {
        Estacionamiento estacionamiento = EstacionamientoMapper.instance.estacionamientoCrearDTOToEstacionamiento(entity);
        return EstacionamientoMapper.instance.estacionamientoToEstacionamientoDTO(repository.save(estacionamiento));
    }

    @Override
    public EstacionamientoDTO actualizar(EstacionamientoDTO entity) {
        Estacionamiento estacionamiento = EstacionamientoMapper.instance.estacionamientoDTOToEstacionamiento(entity);
        return EstacionamientoMapper.instance.estacionamientoToEstacionamientoDTO(repository.save(estacionamiento));
    }

    @Override
    public List<EstacionamientoDTO> listarTodo() {
        return EstacionamientoMapper.instance.listarEstacionamientosToEstacionamientoDTO(repository.findAll());
    }

    @Override
    public EstacionamientoDTO listarUno(Integer id) {
        Optional<Estacionamiento> estacionamiento = repository.findById(id);
        return estacionamiento.map( EstacionamientoMapper.instance :: estacionamientoToEstacionamientoDTO).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        Optional<Estacionamiento> estacionamiento = repository.findById(id);
        if(estacionamiento.isPresent()){
            repository.deleteById(id);
        }
    }
}
