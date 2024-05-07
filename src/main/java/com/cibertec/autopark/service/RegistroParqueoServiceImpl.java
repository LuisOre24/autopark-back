package com.cibertec.autopark.service;

import com.cibertec.autopark.dtos.RegistroParqueoCreateDTO;
import com.cibertec.autopark.dtos.RegistroParqueoDTO;
import com.cibertec.autopark.dtos.RegistroParqueoUpdateDTO;
import com.cibertec.autopark.mapper.RegistroParqueoMapper;
import com.cibertec.autopark.model.RegistroParqueo;
import com.cibertec.autopark.repository.RegistroParqueoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RegistroParqueoServiceImpl implements IRegistroParqueoService {

    @Value("${tolerancia}")
    private int tolerancia;

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

    @Override
    @Transactional
    public String salidaVehiculo(RegistroParqueoUpdateDTO registro) {
        //LocalDateTime hora_ingreso = obtenerRegistroParqueoPorId(registro.getIdParqueo()).getHoraFechaIngreso();
        RegistroParqueo reg = registroParqueoRepository.findById(registro.getIdRegistroParqueo()).orElse(null);
        if(reg != null){
            LocalDateTime hora_ingreso = reg.getHoraFechaIngreso(); //registro.getHoraFechaSalida()// -  registro.getHoraFechaSalida()
            LocalDateTime hora_salida =  LocalDateTime.now();
            int totalHoras = calcularTotalHoras(hora_ingreso,hora_salida);
            registroParqueoRepository.salidaVehiculo(registro.getIdRegistroParqueo(), hora_salida ,totalHoras );
            return "REGISTRO EXITOSO";
        }

        return "ERROR CON LAS HORAS";

    }


    //METODO PARA CALCULAR EL TOTAL DE HORAS trancurridas de parqueo

    private int calcularTotalHoras(LocalDateTime startDate,LocalDateTime endDate){
        int time = 0;

        Period dias = Period.between(startDate.toLocalDate(),endDate.toLocalDate());
        int horas = endDate.getHour() - startDate.getHour();
        int minutos = endDate.getMinute() - startDate.getMinute();

        if(dias.isZero()){
            return horas;
        }
        else{
            if(minutos > tolerancia){
                time = (dias.getDays()*24) + horas + 1;
            }
            else{
                time = (dias.getDays()*24) + horas;
            }
        }
        return time;
    }

}
