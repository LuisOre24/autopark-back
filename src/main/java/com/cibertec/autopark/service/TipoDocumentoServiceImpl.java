package com.cibertec.autopark.service;

import com.cibertec.autopark.dtos.TipoDocumentoCreateDTO;
import com.cibertec.autopark.dtos.TipoDocumentoDTO;
import com.cibertec.autopark.dtos.TipoDocumentoUpdateDTO;
import com.cibertec.autopark.mapper.TipoDocumentoMapper;
import com.cibertec.autopark.model.TipoDocumento;
import com.cibertec.autopark.repository.TipoDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TipoDocumentoServiceImpl implements ITipoDocumentoService{

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    public List<TipoDocumentoDTO> listarTipoDocumentos() {
        return TipoDocumentoMapper.instancia.listarTipoDocumentoATipoDocumentoDTO(tipoDocumentoRepository.findAll());
    }

    @Override
    public TipoDocumentoDTO obtenerTipoDocumentoPorId(Integer id) {
        Optional<TipoDocumento> tipoDocumentoOptinal = tipoDocumentoRepository.findById(id);
        return tipoDocumentoOptinal.map(TipoDocumentoMapper.instancia::tipoDocumentoATipoDocumentoDTO).orElse(null);
    }

    @Override
    public TipoDocumentoDTO registrarTipoDocumento(TipoDocumentoCreateDTO tipoDocumentoCreateDTO) {
        TipoDocumento tipoDocumento = TipoDocumentoMapper.instancia.tipoDocumentoCrearDTOATipoDocumento(tipoDocumentoCreateDTO);
        TipoDocumento respuestaEntity=tipoDocumentoRepository.save(tipoDocumento);
        return TipoDocumentoMapper.instancia.tipoDocumentoATipoDocumentoDTO(respuestaEntity);
    }

    @Override
    public TipoDocumentoDTO actualizarTipoDocumento(TipoDocumentoUpdateDTO tipoDocumentoUpdateDTO) {
        TipoDocumento tipoDocumento = TipoDocumentoMapper.instancia.tipoDocumentoUpdateDTOATipoDocumento(tipoDocumentoUpdateDTO);
        TipoDocumento respuestaEntity=tipoDocumentoRepository.save(tipoDocumento);
        return TipoDocumentoMapper.instancia.tipoDocumentoATipoDocumentoDTO(respuestaEntity);
    }

    @Override
    public String eliminarTipoDocumento(Integer id) {
        Optional<TipoDocumento> tipoDocumentoOptional =tipoDocumentoRepository.findById(id);
        if(tipoDocumentoOptional.isPresent()){
            tipoDocumentoRepository.delete(tipoDocumentoOptional.get());
            return "Registro eliminado";
        }else{
            throw new NoSuchElementException("No se pudo realizar la eliminacion por Id");
        }
    }
    
}
