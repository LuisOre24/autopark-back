package com.cibertec.autopark.service;

import com.cibertec.autopark.dtos.MarcaCreateDTO;
import com.cibertec.autopark.dtos.MarcaDTO;
import com.cibertec.autopark.dtos.MarcaUpdateDTO;
import com.cibertec.autopark.dtos.ParqueoDTO;
import com.cibertec.autopark.mapper.MarcaMapper;
import com.cibertec.autopark.model.Marca;
import com.cibertec.autopark.repository.MarcaRepository;
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
public class MarcaServiceImpl implements IMarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    private final TemplateEngine templateEngine;

    public MarcaServiceImpl(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

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

    @Override
    public String generarPdftoBase24() {
        List<MarcaDTO> listarMarcas= listarMarcas();
        Context context = new Context();
        context.setVariable("listarMarcas", listarMarcas);;
        String htmlContent = templateEngine.process("report-parqueos", context);
        ByteArrayOutputStream outputStream= new ByteArrayOutputStream();
        ConverterProperties converterProperties = new ConverterProperties();
        HtmlConverter.convertToPdf(htmlContent,outputStream,converterProperties);
        byte[]pdfBytes = outputStream.toByteArray();
        String base64content= Base64.getEncoder().encodeToString(pdfBytes);
        return base64content;
    }

}
