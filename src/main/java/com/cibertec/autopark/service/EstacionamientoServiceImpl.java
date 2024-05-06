package com.cibertec.autopark.service;

import com.cibertec.autopark.dtos.EstacionamientoCreateDTO;
import com.cibertec.autopark.dtos.EstacionamientoDTO;
import com.cibertec.autopark.dtos.EstacionamientoUpdateDTO;
import com.cibertec.autopark.mapper.EstacionamientoMapper;
import com.cibertec.autopark.model.Estacionamiento;
import com.cibertec.autopark.repository.EstacionamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EstacionamientoServiceImpl implements EstacionamientoService{
    @Autowired
    private EstacionamientoRepository estacionamientoRepository;

    @Override
    public List<EstacionamientoDTO> listarEstacionamientos() {
        return EstacionamientoMapper.instancia.listarEstacionamientoAListarEstacionamientoDTO(estacionamientoRepository.findAll());
    }

    @Override
    public EstacionamientoDTO obtenerEstacionamientoPorId(Integer id) {
        Optional<Estacionamiento> estacionamientoOptinal = estacionamientoRepository.findById(id);
        return estacionamientoOptinal.map(EstacionamientoMapper.instancia::estacionamientoAEstacionamientoDTO).orElse(null);
    }

    @Override
    public EstacionamientoDTO registrarEstacionamiento(EstacionamientoCreateDTO estacionamientoCreateDTO) {
        Estacionamiento estacionamiento = EstacionamientoMapper.instancia.estacionamientoCreateDTOAEstacionamiento(estacionamientoCreateDTO);
        Estacionamiento respuestaEntity=estacionamientoRepository.save(estacionamiento);
        return EstacionamientoMapper.instancia.estacionamientoAEstacionamientoDTO(respuestaEntity);
    }

    @Override
    public EstacionamientoDTO actualizarEstacionamiento(EstacionamientoUpdateDTO estacionamientoUpdateDTO) {
        Estacionamiento estacionamiento = EstacionamientoMapper.instancia.estacionamientoUpdateDTOAEstacionamiento(estacionamientoUpdateDTO);
        Estacionamiento respuestaEntity=estacionamientoRepository.save(estacionamiento);
        return EstacionamientoMapper.instancia.estacionamientoAEstacionamientoDTO(respuestaEntity);
    }

    @Override
    public String eliminarEstacionamiento(Integer id) {
        Optional<Estacionamiento> estacionamientoOptional =estacionamientoRepository.findById(id);
        if(estacionamientoOptional.isPresent()){
            estacionamientoRepository.delete(estacionamientoOptional.get());
            return "Registro eliminado";
        }else{
            throw new NoSuchElementException("No se pudo realizar la eliminacion por Id");
        }
    }
}
