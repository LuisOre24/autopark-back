package com.cibertec.autopark.service;

import com.cibertec.autopark.dtos.TipoVehiculoCreateDTO;
import com.cibertec.autopark.dtos.TipoVehiculoDTO;
import com.cibertec.autopark.dtos.TipoVehiculoUpdateDTO;
import com.cibertec.autopark.mapper.TipoVehiculoMapper;
import com.cibertec.autopark.model.TipoVehiculo;
import com.cibertec.autopark.repository.TipoVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TipoVehiculoServiceImpl implements TipoVehiculoService{

    /*private final TipoVehiculoRepository tipoVehiculoRepository;

    public TipoVehiculoServiceImpl(TipoVehiculoRepository tipoVehiculoRepository){
        this.tipoVehiculoRepository=tipoVehiculoRepository;
    }*/
    @Autowired
    private TipoVehiculoRepository tipoVehiculoRepository;

    @Override
    public List<TipoVehiculoDTO> listarTipoVehiculos() {
        return TipoVehiculoMapper.instancia.listarTipoVehiculoATipoVehiculoDTO(tipoVehiculoRepository.findAll());
    }

    @Override
    public TipoVehiculoDTO obtenerTipoVehiculoPorId(Integer id) {
        Optional<TipoVehiculo> tipoVehiculo = tipoVehiculoRepository.findById(id);
        return tipoVehiculo.map(TipoVehiculoMapper.instancia::tipoVehiculoATipoVehiculoDTO).orElse(null);
    }

    @Override
    public TipoVehiculoDTO registrarTipoVehiculo(TipoVehiculoCreateDTO tipoVehiculoCreateDTO) {
        TipoVehiculo tipoVehiculo = TipoVehiculoMapper.instancia.tipoVehiculoCrearDTOATipoVehiculo(tipoVehiculoCreateDTO);
        TipoVehiculo respuestaEntity=tipoVehiculoRepository.save(tipoVehiculo);
        return TipoVehiculoMapper.instancia.tipoVehiculoATipoVehiculoDTO(respuestaEntity);
    }

    @Override
    public TipoVehiculoDTO actualizarTipoVehiculo(TipoVehiculoUpdateDTO tipoVehiculoUpdateDTO) {
        TipoVehiculo tipoVehiculo = TipoVehiculoMapper.instancia.tipoVehiculoUpdateDTOATipoVehiculo(tipoVehiculoUpdateDTO);
        TipoVehiculo respuestaEntity = tipoVehiculoRepository.save(tipoVehiculo);
        return TipoVehiculoMapper.instancia.tipoVehiculoATipoVehiculoDTO(respuestaEntity);

    }

    @Override
    public String eliminarTipoVehiculo(Integer id) {
        Optional<TipoVehiculo> tipoVehiculoOptional = tipoVehiculoRepository.findById(id);
        if(tipoVehiculoOptional.isPresent()){
            tipoVehiculoRepository.deleteById(id);
            return "Registro eliminado";
        }else{
            throw new NoSuchElementException("No se pudo realizar la eliminacion por ID");
        }
    }
}

