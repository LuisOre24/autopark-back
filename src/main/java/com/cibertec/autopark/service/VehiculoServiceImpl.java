package com.cibertec.autopark.service;

import com.cibertec.autopark.dtos.TarifarioDTO;
import com.cibertec.autopark.dtos.VehiculoCreateDTO;
import com.cibertec.autopark.dtos.VehiculoDTO;
import com.cibertec.autopark.dtos.VehiculoUpdateDTO;
import com.cibertec.autopark.mapper.VehiculoMapper;
import com.cibertec.autopark.model.Vehiculo;
import com.cibertec.autopark.repository.VehiculoRepository;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.ByteArrayOutputStream;
import java.time.Instant;
import java.util.Base64;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    private final TemplateEngine templateEngine;

    public VehiculoServiceImpl(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

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
    System.out.print("ingresa a actualizar");
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

    @Override
    public VehiculoDTO buscarPlaca(String placa) {
        Vehiculo vehiculo = vehiculoRepository.buscarPlaca(placa);
        VehiculoDTO neoVehiculo = VehiculoMapper.instancia.vehiculoAVehiculoDTO(vehiculo);
        return neoVehiculo;
    }

    @Override
    public String generarPdftoBase24() {
        List<VehiculoDTO> listarVehiculos = listarVehiculos();
        Context context = new Context();
        context.setVariable("listarVehiculos", listarVehiculos);;
        String htmlContent = templateEngine.process("report-vehiculos", context);
        ByteArrayOutputStream outputStream= new ByteArrayOutputStream();
        ConverterProperties converterProperties = new ConverterProperties();
        HtmlConverter.convertToPdf(htmlContent,outputStream,converterProperties);
        byte[]pdfBytes = outputStream.toByteArray();
        String base64content= Base64.getEncoder().encodeToString(pdfBytes);
        return base64content;
    }

    //METODO QUE PERMITE FORMATEAR LA PLACA QUE INGRESE SIN GUION Y VALIDA SI ES DE SOLO 6 CARACTERES PARA APLICARLA
    private String formatPlacaVehiculo(String placa){
        String neoPlaca = "";
        if(placa.length()<7) {
            System.out.print("antes de: "+ placa);
            neoPlaca = (placa.substring(0, 3) + "-" + placa.substring(3)).toUpperCase();
            System.out.print("despues de: "+ placa);
        }
        else{
            neoPlaca = placa.toUpperCase();
            System.out.print("else: "+ placa);
        }
    return neoPlaca;
    }


}
