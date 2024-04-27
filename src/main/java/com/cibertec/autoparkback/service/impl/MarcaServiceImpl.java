package com.cibertec.autoparkback.service.impl;

import com.cibertec.autoparkback.dto.MarcaCreateDTO;
import com.cibertec.autoparkback.dto.MarcaDTO;
import com.cibertec.autoparkback.mapper.MarcaMapper;
import com.cibertec.autoparkback.model.Marca;
import com.cibertec.autoparkback.repository.IMarcaRepository;
import com.cibertec.autoparkback.service.IMarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaServiceImpl implements IMarcaService {

    @Autowired
    private IMarcaRepository repository;

    @Override
    public MarcaDTO registrar(MarcaCreateDTO entity) {
        Marca marca = MarcaMapper.instance.marcaCrearDTOToMarca(entity);
        return MarcaMapper.instance.marcaToMarcaDTO(repository.save(marca));
    }

    @Override
    public MarcaDTO actualizar(MarcaDTO entity) {
        Marca marca = MarcaMapper.instance.marcaDTOToMarca(entity);
        return MarcaMapper.instance.marcaToMarcaDTO(repository.save(marca));
    }

    @Override
    public List<MarcaDTO> listarTodo() {
        return MarcaMapper.instance.listarMarcasToMarcaDTO(repository.findAll());
    }

    @Override
    public MarcaDTO listarUno(Integer id) {
        Optional<Marca> marca = repository.findById(id);
        return marca.map( MarcaMapper.instance :: marcaToMarcaDTO).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        Optional<Marca> marca = repository.findById(id);
        if(marca.isPresent()){
            repository.deleteById(id);
        }
    }
}
