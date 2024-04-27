package com.cibertec.autoparkback.service.impl;

import com.cibertec.autoparkback.dto.VehiculoCreateDTO;
import com.cibertec.autoparkback.dto.VehiculoDTO;
import com.cibertec.autoparkback.mapper.VehiculoMapper;
import com.cibertec.autoparkback.model.Vehiculo;
import com.cibertec.autoparkback.repository.IVehiculoRepository;
import com.cibertec.autoparkback.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

    @Autowired
    private IVehiculoRepository repository;

    @Override
    public VehiculoDTO registrar(VehiculoCreateDTO entity) {
        Vehiculo vehiculo = VehiculoMapper.instance.vehiculoCrearDTOToVehiculo(entity);
        return VehiculoMapper.instance.vehiculoToVehiculoDTO(repository.save(vehiculo));
    }

    @Override
    public VehiculoDTO actualizar(VehiculoDTO entity) {
        Vehiculo vehiculo = VehiculoMapper.instance.vehiculoDTOToVehiculo(entity);
        return VehiculoMapper.instance.vehiculoToVehiculoDTO(repository.save(vehiculo));
    }

    @Override
    public List<VehiculoDTO> listarTodo() {
        return VehiculoMapper.instance.listarVehiculosToVehiculoDTO(repository.findAll());
    }

    @Override
    public VehiculoDTO listarUno(Integer id) {
        Optional<Vehiculo> vehiculo = repository.findById(id);
        return vehiculo.map( VehiculoMapper.instance :: vehiculoToVehiculoDTO).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        Optional<Vehiculo> vehiculo = repository.findById(id);
        if(vehiculo.isPresent()){
            repository.deleteById(id);
        }
    }
}
