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

        for (Cliente cli : lista) {
            System.out.println(" "+ cli.getId().toString() +" --> "+ cli.getFechaNacimiento().toString());
        }

        return ClienteMapper.instancia.listaClienteAListaClienteDTO( clienteRepository.findAll());
    }

    @Override
    public ClienteDTO obtenerClientePorID(long id) {
        Optional<Cliente> vehiculo= clienteRepository.findById(id);
        ClienteDTO clienteDTO=null ;
        if(vehiculo.isPresent()){
            clienteDTO = ClienteMapper.instancia.clienteAClienteDTO(vehiculo.get());
        }
        return  clienteDTO;
    }

    @Override
    public ClienteDTO registrarCliente(ClienteCreateDTO vehiculoCreateDTO) {
        Cliente vehiculo=ClienteMapper.instancia.clienteCreateDTOACliente(vehiculoCreateDTO);
        Cliente respuestaEntity=clienteRepository.save(vehiculo);
        ClienteDTO respuestaDTO= ClienteMapper.instancia.clienteAClienteDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public ClienteDTO actualizarCliente(ClienteUpdateDTO clienteUpdateDTO) {

        Cliente vehiculo=ClienteMapper.instancia.clienteUpdateDTOACliente(clienteUpdateDTO);
        Cliente respuestaEntity=clienteRepository.save(vehiculo);
        ClienteDTO respuestaDTO= ClienteMapper.instancia.clienteAClienteDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public String eliminarCliente(long id) {
        Optional<Cliente> vehiculoOptional= clienteRepository.findById(id);
        if(vehiculoOptional.isPresent()){
            clienteRepository.delete(vehiculoOptional.get());
            return "Registro eliminado";
        }else {
            throw new NoSuchElementException("No se pudo realizar la eliminación para el ID proporcionado");
        }
    }
}
