package com.cibertec.autopark.service;
import com.cibertec.autopark.dtos.EmpleadoCreateDTO;
import com.cibertec.autopark.dtos.EmpleadoDTO;
import com.cibertec.autopark.mapper.EmpleadoMapper;
import com.cibertec.autopark.model.Empleado;
import com.cibertec.autopark.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<EmpleadoDTO> listarEmpleados() {
        return EmpleadoMapper.instancia.listarEmpleadoAListarEmpleadoDTO(empleadoRepository.findAll());
    }

    @Override
    public EmpleadoDTO obtenerEmpleadoPorId(Integer id) {
        Optional<Empleado> empleadoOptinal = empleadoRepository.findById(id);
        return empleadoOptinal.map(EmpleadoMapper.instancia::empleadoAEmpleadoDTO).orElse(null);
    }

    @Override
    public EmpleadoDTO registrarEmpleado(EmpleadoCreateDTO empleadoCreateDTO) {
        Empleado empleado = EmpleadoMapper.instancia.empleadoCreateDTOAEmpleado(empleadoCreateDTO);
        /*empleado.setPassword(passwordEncoder.encode(empleado.getPassword()));*/
        Empleado respuestaEntity=empleadoRepository.save(empleado);
        return EmpleadoMapper.instancia.empleadoAEmpleadoDTO(respuestaEntity);
    }

    @Override
    public EmpleadoDTO actualizarEmpleado(EmpleadoDTO empleadoUpdateDTO) {
        Empleado empleado = EmpleadoMapper.instancia.empleadoUpdateDTOAEmpleado(empleadoUpdateDTO);
        Empleado respuestaEntity=empleadoRepository.save(empleado);
        return EmpleadoMapper.instancia.empleadoAEmpleadoDTO(respuestaEntity);
    }

    @Override
    public String eliminarEmpleado(Integer id) {
        Optional<Empleado> empleadoOptional =empleadoRepository.findById(id);
        if(empleadoOptional.isPresent()){
            empleadoRepository.delete(empleadoOptional.get());
            return "Registro eliminado";
        }else{
            throw new NoSuchElementException("No se pudo realizar la eliminacion por Id");
        }
    }
}
