package com.cibertec.autopark.service;

import com.cibertec.autopark.dtos.MarcaCreateDTO;
import com.cibertec.autopark.dtos.MarcaDTO;
import com.cibertec.autopark.dtos.MarcaUpdateDTO;
import com.cibertec.autopark.mapper.MarcaMapper;
import com.cibertec.autopark.model.Marca;
import com.cibertec.autopark.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class MarcaServiceImpl implements MarcaService{

    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public List<MarcaDTO> listarMarcas() {
        return MarcaMapper.instancia.listarMarcaAListarMarcaDTO(marcaRepository.findAll());
    }

    @Override
    public MarcaDTO obtenerMarcaPorId(Integer id) {
        Optional<Marca> marcaOptinal = marcaRepository.findById(id);
        return marcaOptinal.map(MarcaMapper.instancia::marcaAMarcaDTO).orElse(null);
    }

    @Override
    public MarcaDTO registrarMarca(MarcaCreateDTO marcaCreateDTO) {
        Marca marca = MarcaMapper.instancia.marcaCreateDTOAMarca(marcaCreateDTO);
        Marca respuestaEntity=marcaRepository.save(marca);
        return MarcaMapper.instancia.marcaAMarcaDTO(respuestaEntity);
    }

    @Override
    public MarcaDTO actualizarMarca(MarcaUpdateDTO marcaUpdateDTO) {
        Marca marca = MarcaMapper.instancia.marcaUpdateDTOAMarca(marcaUpdateDTO);
        Marca respuestaEntity=marcaRepository.save(marca);
        return MarcaMapper.instancia.marcaAMarcaDTO(respuestaEntity);
    }

    @Override
    public String eliminarMarca(Integer id) {
        Optional<Marca> marcaOptional =marcaRepository.findById(id);
        if(marcaOptional.isPresent()){
            marcaRepository.delete(marcaOptional.get());
            return "Registro eliminado";
        }else{
            throw new NoSuchElementException("No se pudo realizar la eliminacion por Id");
        }
    }

}
