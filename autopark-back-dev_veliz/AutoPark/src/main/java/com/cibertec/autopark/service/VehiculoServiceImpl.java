package com.cibertec.autopark.service;

import com.cibertec.autopark.dtos.VehiculoCreateDTO;
import com.cibertec.autopark.dtos.VehiculoDTO;
import com.cibertec.autopark.dtos.VehiculoUpdateDTO;
import com.cibertec.autopark.mapper.VehiculoMapper;
import com.cibertec.autopark.model.Vehiculo;
import com.cibertec.autopark.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class VehiculoServiceImpl implements VehiculoService{

    @Autowired
    private VehiculoRepository vehiculoRepository;

    /*private final VehiculoRepository vehiculoRepository;

    public VehiculoServiceImpl(VehiculoRepository vehiculoRepository){
        this.vehiculoRepository=vehiculoRepository;
    }*/

    @Override
    public List<VehiculoDTO> listarVehiculos() {
        return VehiculoMapper.instancia.listaVehiculoAListaVehiculoDTO( vehiculoRepository.findAll());
    }

    @Override
    public VehiculoDTO obtenerVehiculoPorID(Integer id) {
        Optional<Vehiculo> vehiculo = vehiculoRepository.findById(id);
        return vehiculo.map(VehiculoMapper.instancia::vehiculoAVehiculoDTO).orElse(null);
    }

    @Override
    public VehiculoDTO registrarVehiculo(VehiculoCreateDTO vehiculoCreateDTO) {
        Vehiculo vehiculo=VehiculoMapper.instancia.vehiculoCreateDTOAVehiculo(vehiculoCreateDTO);
        Vehiculo respuestaEntity=vehiculoRepository.save(vehiculo);
        return VehiculoMapper.instancia.vehiculoAVehiculoDTO(respuestaEntity);
    }

    @Override
    public VehiculoDTO actualizarVehiculo(VehiculoUpdateDTO vehiculoUpdateDTO) {

        Vehiculo vehiculo=VehiculoMapper.instancia.vehiculoUpdateDTOAVehiculo(vehiculoUpdateDTO);
        Vehiculo respuestaEntity=vehiculoRepository.save(vehiculo);
        return VehiculoMapper.instancia.vehiculoAVehiculoDTO(respuestaEntity);
    }

    @Override
    public HashMap eliminarVehiculo(Integer id) {
        Optional<Vehiculo> vehiculoOptional = vehiculoRepository.findById(id);
        HashMap hashMap = new HashMap();
        if (vehiculoOptional.isPresent()) {
            vehiculoRepository.delete(vehiculoOptional.get());
            hashMap.put("mensaje","Registro Eliminado");
        } else {
            hashMap.put("mensaje","No se pudo realizar la eliminación");
        }
        return hashMap;
    }
}
