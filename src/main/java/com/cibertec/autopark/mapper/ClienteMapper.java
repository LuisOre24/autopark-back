package com.cibertec.autopark.mapper;

import com.cibertec.autopark.dtos.ClienteCreateDTO;
import com.cibertec.autopark.dtos.ClienteDTO;
import com.cibertec.autopark.dtos.ClienteUpdateDTO;
import com.cibertec.autopark.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface ClienteMapper {

    ClienteMapper instancia= Mappers.getMapper(ClienteMapper.class);

    @Mapping(target = "tipoDocumentoDTO", source = "tipoDocumento")
    ClienteDTO clienteAClienteDTO(Cliente cliente);

    @Mapping(target = "tipoDocumento", source = "tipoDocumentoDTO")
    Cliente clienteDTOACliente(ClienteDTO clienteDTO);

    @Mapping(target = "tipoDocumento", source = "tipoDocumentoDTO")
    Cliente clienteCreateDTOACliente(ClienteCreateDTO clienteCreateDTO);

    @Mapping(target = "tipoDocumento", source = "tipoDocumentoDTO")
    Cliente clienteUpdateDTOACliente(ClienteUpdateDTO clienteUpdateDTO);

    @Mapping(target = "tipoDocumentoDTO", source = "tipoDocumento")
    List<ClienteDTO> listaClienteAListaClienteDTO (List<Cliente> listaCliente);
}
