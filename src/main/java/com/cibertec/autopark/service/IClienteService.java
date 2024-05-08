package com.cibertec.autopark.service;

import com.cibertec.autopark.dtos.ClienteCreateDTO;
import com.cibertec.autopark.dtos.ClienteDTO;
import com.cibertec.autopark.dtos.ClienteUpdateDTO;

import java.util.List;

public interface IClienteService {
    List<ClienteDTO> listarClientes();
    ClienteDTO obtenerClientePorID(long id);
    ClienteDTO registrarCliente(ClienteCreateDTO clienteCreateDTO);
    ClienteDTO actualizarCliente(ClienteUpdateDTO clienteUpdateDTO);
    String eliminarCliente(long id);

    ClienteDTO buscarClienteDocumento(String nroDocumento);

    String generarPdftoBase24();
}
