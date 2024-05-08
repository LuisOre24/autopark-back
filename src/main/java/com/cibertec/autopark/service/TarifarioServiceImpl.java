package com.cibertec.autopark.service;

import com.cibertec.autopark.dtos.ClienteDTO;
import com.cibertec.autopark.dtos.TarifarioCreateDTO;
import com.cibertec.autopark.dtos.TarifarioDTO;
import com.cibertec.autopark.mapper.TarifarioMapper;
import com.cibertec.autopark.model.Tarifario;
import com.cibertec.autopark.repository.TarifarioRepository;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TarifarioServiceImpl implements ITarifarioService{

    @Autowired
    private TarifarioRepository tarifarioRepository;

    private final TemplateEngine templateEngine;

    public TarifarioServiceImpl(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    public List<TarifarioDTO> listarTarifarios() {
        return TarifarioMapper.instancia.listarTarifarioAListarTarifarioDTO(tarifarioRepository.findAll());
    }

    @Override
    public TarifarioDTO obtenerTarifarioPorId(Integer id) {
        Optional<Tarifario> tarifarioOptinal = tarifarioRepository.findById(id);
        return tarifarioOptinal.map(TarifarioMapper.instancia::TarifarioATarifarioDTO).orElse(null);
    }

    @Override
    public TarifarioDTO registrarTarifario(TarifarioCreateDTO tarifarioCreateDTO) {
        Tarifario tarifario = TarifarioMapper.instancia.TarifarioCreateDTOATarifario(tarifarioCreateDTO);
        Tarifario respuestaEntity=tarifarioRepository.save(tarifario);
        return TarifarioMapper.instancia.TarifarioATarifarioDTO(respuestaEntity);
    }

    @Override
    public TarifarioDTO actualizarTarifario(TarifarioDTO tarifarioUpdateDTO) {
        Tarifario tarifario = TarifarioMapper.instancia.TarifarioUpdateDTOATarifario(tarifarioUpdateDTO);
        Tarifario respuestaEntity=tarifarioRepository.save(tarifario);
        return TarifarioMapper.instancia.TarifarioATarifarioDTO(respuestaEntity);
    }

    @Override
    public String eliminarTarifario(Integer id) {
        Optional<Tarifario> tarifarioOptional =tarifarioRepository.findById(id);
        if(tarifarioOptional.isPresent()){
            tarifarioRepository.delete(tarifarioOptional.get());
            return "Registro eliminado";
        }else{
            throw new NoSuchElementException("No se pudo realizar la eliminacion por Id");
        }
    }

    @Override
    public TarifarioDTO tarifaPorTVehiculo(Integer id) {
        Tarifario tarifario = tarifarioRepository.tarifaPorTVehiculo(id);
        TarifarioDTO tarifarioDTO = TarifarioMapper.instancia.TarifarioATarifarioDTO(tarifario);
        return tarifarioDTO;
    }

    @Override
    public String generarPdftoBase24() {
        List<TarifarioDTO> listarTarifarios = listarTarifarios();
        Context context = new Context();
        context.setVariable("listarTarifarios", listarTarifarios);;
        String htmlContent = templateEngine.process("report-tarifarios", context);
        ByteArrayOutputStream outputStream= new ByteArrayOutputStream();
        ConverterProperties converterProperties = new ConverterProperties();
        HtmlConverter.convertToPdf(htmlContent,outputStream,converterProperties);
        byte[]pdfBytes = outputStream.toByteArray();
        String base64content= Base64.getEncoder().encodeToString(pdfBytes);
        return base64content;
    }
}
