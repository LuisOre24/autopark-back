package com.cibertec.autopark.service;

import com.cibertec.autopark.dtos.RegistroParqueoCreateDTO;
import com.cibertec.autopark.dtos.RegistroParqueoDTO;
import com.cibertec.autopark.mapper.RegistroParqueoMapper;
import com.cibertec.autopark.model.RegistroParqueo;
import com.cibertec.autopark.repository.RegistroParqueoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RegistroParqueoServiceImpl implements IRegistroParqueoService {

    @Autowired
    private RegistroParqueoRepository registroParqueoRepository;

    @Override
    public List<RegistroParqueoDTO> listarRegistroParqueos() {
        return RegistroParqueoMapper.instancia.listaRegistroParqueoAListaRegistroParqueoDTO(registroParqueoRepository.findAll());
    }

    @Override
    public RegistroParqueoDTO obtenerRegistroParqueoPorId(Integer id) {
        Optional<RegistroParqueo> registroParqueoOptinal = registroParqueoRepository.findById(id);
        return registroParqueoOptinal.map(RegistroParqueoMapper.instancia::registroParqueoARegistroParqueoDTO).orElse(null);
    }

    @Override
    public RegistroParqueoDTO registrarRegistroParqueo(RegistroParqueoCreateDTO registroParqueoCreateDTO) {
        RegistroParqueo registroParqueo = RegistroParqueoMapper.instancia.registroParqueoCreateDTOARegistroParqueo(registroParqueoCreateDTO);
        RegistroParqueo respuestaEntity=registroParqueoRepository.save(registroParqueo);
        return RegistroParqueoMapper.instancia.registroParqueoARegistroParqueoDTO(respuestaEntity);
    }

    @Override
    public RegistroParqueoDTO actualizarRegistroParqueo(RegistroParqueoDTO registroParqueoUpdateDTO) {
        RegistroParqueo registroParqueo = RegistroParqueoMapper.instancia.registroParqueoDTOARegistroParqueo(registroParqueoUpdateDTO);
        RegistroParqueo respuestaEntity=registroParqueoRepository.save(registroParqueo);
        return RegistroParqueoMapper.instancia.registroParqueoARegistroParqueoDTO(respuestaEntity);
    }

    @Override
    public String eliminarRegistroParqueo(Integer id) {
        Optional<RegistroParqueo> registroParqueoOptional =registroParqueoRepository.findById(id);
        if(registroParqueoOptional.isPresent()){
            registroParqueoRepository.delete(registroParqueoOptional.get());
            return "Registro eliminado";
        }else{
            throw new NoSuchElementException("No se pudo realizar la eliminacion por Id");
        }
    }

}
