package com.cibertec.autoparkback.service.impl;

import com.cibertec.autoparkback.dto.TarifarioCreateDTO;
import com.cibertec.autoparkback.dto.TarifarioDTO;
import com.cibertec.autoparkback.mapper.TarifarioMapper;
import com.cibertec.autoparkback.model.Tarifario;
import com.cibertec.autoparkback.repository.ITarifarioRepository;
import com.cibertec.autoparkback.service.ITarifarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarifarioServiceImpl implements ITarifarioService {

    @Autowired
    private ITarifarioRepository repository;

    @Override
    public TarifarioDTO registrar(TarifarioCreateDTO entity) {
        Tarifario tarifario = TarifarioMapper.instance.tarifarioCrearDTOToTarifario(entity);
        return TarifarioMapper.instance.tarifarioToTarifarioDTO(repository.save(tarifario));
    }

    @Override
    public TarifarioDTO actualizar(TarifarioDTO entity) {
        Tarifario tarifario = TarifarioMapper.instance.tarifarioDTOToTarifario(entity);
        return TarifarioMapper.instance.tarifarioToTarifarioDTO(repository.save(tarifario));
    }

    @Override
    public List<TarifarioDTO> listarTodo() {
        return TarifarioMapper.instance.listarTarifariosToTarifarioDTO(repository.findAll());
    }

    @Override
    public TarifarioDTO listarUno(Integer id) {
        Optional<Tarifario> tarifario = repository.findById(id);
        return tarifario.map( TarifarioMapper.instance :: tarifarioToTarifarioDTO).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        Optional<Tarifario> tarifario = repository.findById(id);
        if(tarifario.isPresent()){
            repository.deleteById(id);
        }
    }
}
