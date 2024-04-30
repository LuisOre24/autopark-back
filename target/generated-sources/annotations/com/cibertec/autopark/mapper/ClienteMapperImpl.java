package com.cibertec.autopark.mapper;

import com.cibertec.autopark.dtos.ClienteCreateDTO;
import com.cibertec.autopark.dtos.ClienteDTO;
import com.cibertec.autopark.dtos.ClienteUpdateDTO;
import com.cibertec.autopark.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-29T16:37:11-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteDTO clienteAClienteDTO(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setId( cliente.getId() );
        clienteDTO.setDni( cliente.getDni() );
        clienteDTO.setNombres( cliente.getNombres() );
        clienteDTO.setApePaterno( cliente.getApePaterno() );
        clienteDTO.setApeMaterno( cliente.getApeMaterno() );
        clienteDTO.setFechaNacimiento( cliente.getFechaNacimiento() );
        clienteDTO.setEmail( cliente.getEmail() );

        return clienteDTO;
    }

    @Override
    public Cliente clienteDTOACliente(ClienteDTO clienteDTO) {
        if ( clienteDTO == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setId( clienteDTO.getId() );
        cliente.setDni( clienteDTO.getDni() );
        cliente.setNombres( clienteDTO.getNombres() );
        cliente.setApePaterno( clienteDTO.getApePaterno() );
        cliente.setApeMaterno( clienteDTO.getApeMaterno() );
        cliente.setFechaNacimiento( clienteDTO.getFechaNacimiento() );
        cliente.setEmail( clienteDTO.getEmail() );

        return cliente;
    }

    @Override
    public Cliente clienteCreateDTOACliente(ClienteCreateDTO clienteCreateDTO) {
        if ( clienteCreateDTO == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setDni( clienteCreateDTO.getDni() );
        cliente.setNombres( clienteCreateDTO.getNombres() );
        cliente.setApePaterno( clienteCreateDTO.getApePaterno() );
        cliente.setApeMaterno( clienteCreateDTO.getApeMaterno() );
        cliente.setFechaNacimiento( clienteCreateDTO.getFechaNacimiento() );
        cliente.setEmail( clienteCreateDTO.getEmail() );

        return cliente;
    }

    @Override
    public Cliente clienteUpdateDTOACliente(ClienteUpdateDTO clienteUpdateDTO) {
        if ( clienteUpdateDTO == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setId( clienteUpdateDTO.getId() );
        cliente.setDni( clienteUpdateDTO.getDni() );
        cliente.setNombres( clienteUpdateDTO.getNombres() );
        cliente.setApePaterno( clienteUpdateDTO.getApePaterno() );
        cliente.setApeMaterno( clienteUpdateDTO.getApeMaterno() );
        cliente.setFechaNacimiento( clienteUpdateDTO.getFechaNacimiento() );
        cliente.setEmail( clienteUpdateDTO.getEmail() );

        return cliente;
    }

    @Override
    public List<ClienteDTO> listaClienteAListaClienteDTO(List<Cliente> listaCliente) {
        if ( listaCliente == null ) {
            return null;
        }

        List<ClienteDTO> list = new ArrayList<ClienteDTO>( listaCliente.size() );
        for ( Cliente cliente : listaCliente ) {
            list.add( clienteAClienteDTO( cliente ) );
        }

        return list;
    }
}
