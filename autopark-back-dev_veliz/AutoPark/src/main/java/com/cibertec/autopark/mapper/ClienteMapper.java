package com.cibertec.autopark.mapper;

import com.cibertec.autopark.dtos.ClienteCreateDTO;
import com.cibertec.autopark.dtos.ClienteDTO;
import com.cibertec.autopark.dtos.ClienteUpdateDTO;
import com.cibertec.autopark.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface ClienteMapper {

    ClienteMapper instancia= Mappers.getMapper(ClienteMapper.class);

    ClienteDTO clienteAClienteDTO(Cliente cliente);
    Cliente clienteDTOACliente(ClienteDTO clienteDTO);
    Cliente clienteCreateDTOACliente(ClienteCreateDTO clienteCreateDTO);
    Cliente clienteUpdateDTOACliente(ClienteUpdateDTO clienteUpdateDTO);
    List<ClienteDTO> listaClienteAListaClienteDTO (List<Cliente> listaCliente);
}
