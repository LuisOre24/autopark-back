package com.cibertec.autopark.service;

import com.cibertec.autopark.dtos.ClienteCreateDTO;
import com.cibertec.autopark.dtos.ClienteDTO;
import com.cibertec.autopark.dtos.ClienteUpdateDTO;
import com.cibertec.autopark.mapper.ClienteMapper;
import com.cibertec.autopark.model.Cliente;
import com.cibertec.autopark.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteDTO> listarClientes() {
        List<Cliente> lista = clienteRepository.findAll();

        return ClienteMapper.instancia.listaClienteAListaClienteDTO( clienteRepository.findAll());
    }

    @Override
    public ClienteDTO obtenerClientePorID(long id) {
        Optional<Cliente> cliente= clienteRepository.findById(id);
        ClienteDTO clienteDTO=null ;
        if(cliente.isPresent()){
            clienteDTO = ClienteMapper.instancia.clienteAClienteDTO(cliente.get());
        }
        return  clienteDTO;
    }

    @Override
    public ClienteDTO registrarCliente(ClienteCreateDTO clienteCreateDTO) {
        Cliente cliente=ClienteMapper.instancia.clienteCreateDTOACliente(clienteCreateDTO);
        Cliente respuestaEntity=clienteRepository.save(cliente);
        ClienteDTO respuestaDTO= ClienteMapper.instancia.clienteAClienteDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public ClienteDTO actualizarCliente(ClienteUpdateDTO clienteUpdateDTO) {

        Cliente cliente=ClienteMapper.instancia.clienteUpdateDTOACliente(clienteUpdateDTO);
        Cliente respuestaEntity=clienteRepository.save(cliente);
        ClienteDTO respuestaDTO= ClienteMapper.instancia.clienteAClienteDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public String eliminarCliente(long id) {
        Optional<Cliente> clienteOptional= clienteRepository.findById(id);
        if(clienteOptional.isPresent()){
            clienteRepository.delete(clienteOptional.get());
            return "Registro eliminado";
        }else {
            throw new NoSuchElementException("No se pudo realizar la eliminación para el ID proporcionado");
        }
    }

    @Override
    public ClienteDTO buscarClienteDocumento(String nroDocumento) {
        Cliente cliente = clienteRepository.buscarClienteDocumento(nroDocumento);
        ClienteDTO clienteDTO = ClienteMapper.instancia.clienteAClienteDTO(cliente);
        return clienteDTO;
    }


}
