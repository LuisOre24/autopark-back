package com.cibertec.autopark.service;

import com.cibertec.autopark.dtos.VehiculoCreateDTO;
import com.cibertec.autopark.dtos.VehiculoDTO;
import com.cibertec.autopark.dtos.VehiculoUpdateDTO;
import com.cibertec.autopark.mapper.VehiculoMapper;
import com.cibertec.autopark.model.Vehiculo;
import com.cibertec.autopark.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

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
        vehiculo.setPlaca(formatPlacaVehiculo(vehiculo.getPlaca()));
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
    public String eliminarVehiculo(Integer id) {
        Optional<Vehiculo> vehiculoOptional = vehiculoRepository.findById(id);

        if (vehiculoOptional.isPresent()) {
            vehiculoRepository.delete(vehiculoOptional.get());
            return "Registro eliminado";
        } else {
            throw new NoSuchElementException("No se pudo realizar la eliminacion por ID");
        }
    }

    private String formatPlacaVehiculo(String placa){
        String neoPlaca = "";
        if(placa.length()<7) {
            neoPlaca = (placa.substring(0, 3) + "-" + placa.substring(3)).toUpperCase();
        }
        else{
            neoPlaca = placa.toUpperCase();
        }
    return neoPlaca;
    }
}
