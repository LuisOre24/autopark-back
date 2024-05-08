package com.cibertec.autopark.controller;

import com.cibertec.autopark.dtos.ClienteCreateDTO;
import com.cibertec.autopark.dtos.ClienteDTO;
import com.cibertec.autopark.dtos.ClienteUpdateDTO;
import com.cibertec.autopark.service.IClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ClienteController {

    private final IClienteService IClienteService;
    public ClienteController(IClienteService IClienteService){
        this.IClienteService = IClienteService;
    }

    @GetMapping("clientes")
    public ResponseEntity<List<ClienteDTO>> listarClientes(){
        return   new ResponseEntity<>(IClienteService.listarClientes(), HttpStatus.OK);
    }

    @GetMapping("/clientes/{clienteId}")
    public ResponseEntity<ClienteDTO> obtenerClientePorId(@PathVariable("clienteId") long clienteId){
        return  new ResponseEntity<> ( IClienteService.obtenerClientePorID(clienteId),HttpStatus.OK);
    }

    @PostMapping("clientes")
    public ResponseEntity<ClienteDTO> registrarCliente(@RequestBody ClienteCreateDTO clienteCreateDTO){
        return  new ResponseEntity <>( IClienteService.registrarCliente(clienteCreateDTO) ,HttpStatus.OK) ;
    }

    @PutMapping("clientes")
    public ResponseEntity<ClienteDTO> actualizarCliente(@RequestBody ClienteUpdateDTO clienteUpdateDTO){
        return new ResponseEntity<>(IClienteService.actualizarCliente(clienteUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/clientes/{clienteId}")
    public ResponseEntity<?> eliminarCliente(@PathVariable("clienteId") long clienteId) {
        String text =IClienteService.eliminarCliente(clienteId);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @GetMapping("clientes/buscar/{documento}")
    public ResponseEntity<?> buscarClienteDocumento(@PathVariable("documento") String documento){
        ClienteDTO cliente = IClienteService.buscarClienteDocumento(documento);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @GetMapping("clientes/reporte")
    public ResponseEntity<String> generarReportBase64() throws Exception{
        return new ResponseEntity<>(IClienteService.generarPdftoBase24(),HttpStatus.OK);
    }
}
