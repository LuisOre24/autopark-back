package com.cibertec.autoparkback.service.impl;

import com.cibertec.autoparkback.dto.TipoVehiculoCreateDTO;
import com.cibertec.autoparkback.dto.TipoVehiculoDTO;
import com.cibertec.autoparkback.mapper.TipoVehiculoMapper;
import com.cibertec.autoparkback.model.TipoVehiculo;
import com.cibertec.autoparkback.repository.ITipoVehiculoRepository;
import com.cibertec.autoparkback.service.ITipoVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoVehiculoServiceImpl implements ITipoVehiculoService {

    @Autowired
    private ITipoVehiculoRepository repository;

    @Override
    public TipoVehiculoDTO registrar(TipoVehiculoCreateDTO entity) {
        TipoVehiculo tipoVehiculo = TipoVehiculoMapper.instance.tipoVehiculoCrearDTOToTipoVehiculo(entity);
        return TipoVehiculoMapper.instance.tipoVehiculoToTipoVehiculoDTO(repository.save(tipoVehiculo));
    }

    @Override
    public TipoVehiculoDTO actualizar(TipoVehiculoDTO entity) {
        TipoVehiculo tipoVehiculo = TipoVehiculoMapper.instance.tipoVehiculoDTOToTipoVehiculo(entity);
        return TipoVehiculoMapper.instance.tipoVehiculoToTipoVehiculoDTO(repository.save(tipoVehiculo));
    }

    @Override
    public List<TipoVehiculoDTO> listarTodo() {
        return TipoVehiculoMapper.instance.listarTipoVehiculosToTipoVehiculoDTO(repository.findAll());
    }

    @Override
    public TipoVehiculoDTO listarUno(Integer id) {
        Optional<TipoVehiculo> tipoVehiculo = repository.findById(id);
        return tipoVehiculo.map( TipoVehiculoMapper.instance :: tipoVehiculoToTipoVehiculoDTO).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        Optional<TipoVehiculo> tipoVehiculo = repository.findById(id);
        if(tipoVehiculo.isPresent()){
            repository.deleteById(id);
        }
    }
}
