package com.cibertec.autopark.mapper;

import com.cibertec.autopark.dtos.ClienteDTO;
import com.cibertec.autopark.dtos.MarcaDTO;
import com.cibertec.autopark.dtos.TipoVehiculoDTO;
import com.cibertec.autopark.dtos.VehiculoCreateDTO;
import com.cibertec.autopark.dtos.VehiculoDTO;
import com.cibertec.autopark.dtos.VehiculoUpdateDTO;
import com.cibertec.autopark.model.Cliente;
import com.cibertec.autopark.model.Marca;
import com.cibertec.autopark.model.TipoVehiculo;
import com.cibertec.autopark.model.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-08T02:26:44-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Eclipse Adoptium)"
)
public class VehiculoMapperImpl implements VehiculoMapper {

    @Override
    public VehiculoDTO vehiculoAVehiculoDTO(Vehiculo vehiculo) {
        if ( vehiculo == null ) {
            return null;
        }

        VehiculoDTO vehiculoDTO = new VehiculoDTO();

        vehiculoDTO.setTipoVehiculoDTO( tipoVehiculoToTipoVehiculoDTO( vehiculo.getTipoVehiculo() ) );
        vehiculoDTO.setMarcaDTO( marcaToMarcaDTO( vehiculo.getMarca() ) );
        vehiculoDTO.setClienteDTO( clienteToClienteDTO( vehiculo.getCliente() ) );
        vehiculoDTO.setId( vehiculo.getId() );
        vehiculoDTO.setPlaca( vehiculo.getPlaca() );
        vehiculoDTO.setColor( vehiculo.getColor() );

        return vehiculoDTO;
    }

    @Override
    public Vehiculo vehiculoDTOAVehiculo(VehiculoDTO vehiculoDTO) {
        if ( vehiculoDTO == null ) {
            return null;
        }

        Vehiculo vehiculo = new Vehiculo();

        vehiculo.setId( vehiculoDTO.getId() );
        vehiculo.setPlaca( vehiculoDTO.getPlaca() );
        vehiculo.setColor( vehiculoDTO.getColor() );

        return vehiculo;
    }

    @Override
    public Vehiculo vehiculoCreateDTOAVehiculo(VehiculoCreateDTO vehiculoCreateDTO) {
        if ( vehiculoCreateDTO == null ) {
            return null;
        }

        Vehiculo vehiculo = new Vehiculo();

        vehiculo.setTipoVehiculo( tipoVehiculoDTOToTipoVehiculo( vehiculoCreateDTO.getTipoVehiculoDTO() ) );
        vehiculo.setMarca( marcaDTOToMarca( vehiculoCreateDTO.getMarcaDTO() ) );
        vehiculo.setCliente( clienteDTOToCliente( vehiculoCreateDTO.getClienteDTO() ) );
        vehiculo.setPlaca( vehiculoCreateDTO.getPlaca() );
        vehiculo.setColor( vehiculoCreateDTO.getColor() );

        return vehiculo;
    }

    @Override
    public Vehiculo vehiculoUpdateDTOAVehiculo(VehiculoUpdateDTO vehiculoUpdateDTO) {
        if ( vehiculoUpdateDTO == null ) {
            return null;
        }

        Vehiculo vehiculo = new Vehiculo();

        vehiculo.setTipoVehiculo( tipoVehiculoDTOToTipoVehiculo( vehiculoUpdateDTO.getTipoVehiculoDTO() ) );
        vehiculo.setMarca( marcaDTOToMarca( vehiculoUpdateDTO.getMarcaDTO() ) );
        vehiculo.setCliente( clienteDTOToCliente( vehiculoUpdateDTO.getClienteDTO() ) );
        vehiculo.setId( vehiculoUpdateDTO.getId() );
        vehiculo.setPlaca( vehiculoUpdateDTO.getPlaca() );
        vehiculo.setColor( vehiculoUpdateDTO.getColor() );

        return vehiculo;
    }

    @Override
    public List<VehiculoDTO> listaVehiculoAListaVehiculoDTO(List<Vehiculo> listaVehiculo) {
        if ( listaVehiculo == null ) {
            return null;
        }

        List<VehiculoDTO> list = new ArrayList<VehiculoDTO>( listaVehiculo.size() );
        for ( Vehiculo vehiculo : listaVehiculo ) {
            list.add( vehiculoAVehiculoDTO( vehiculo ) );
        }

        return list;
    }

    protected TipoVehiculoDTO tipoVehiculoToTipoVehiculoDTO(TipoVehiculo tipoVehiculo) {
        if ( tipoVehiculo == null ) {
            return null;
        }

        TipoVehiculoDTO tipoVehiculoDTO = new TipoVehiculoDTO();

        tipoVehiculoDTO.setId( tipoVehiculo.getId() );
        tipoVehiculoDTO.setDes_tipoVehiculo( tipoVehiculo.getDes_tipoVehiculo() );

        return tipoVehiculoDTO;
    }

    protected MarcaDTO marcaToMarcaDTO(Marca marca) {
        if ( marca == null ) {
            return null;
        }

        MarcaDTO marcaDTO = new MarcaDTO();

        marcaDTO.setId( marca.getId() );
        marcaDTO.setDes_marca( marca.getDes_marca() );

        return marcaDTO;
    }

    protected ClienteDTO clienteToClienteDTO(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setId( cliente.getId() );
        clienteDTO.setDni( cliente.getDni() );
        clienteDTO.setNombres( cliente.getNombres() );
        clienteDTO.setApePaterno( cliente.getApePaterno() );
        clienteDTO.setApeMaterno( cliente.getApeMaterno() );
        clienteDTO.setEmail( cliente.getEmail() );

        return clienteDTO;
    }

    protected TipoVehiculo tipoVehiculoDTOToTipoVehiculo(TipoVehiculoDTO tipoVehiculoDTO) {
        if ( tipoVehiculoDTO == null ) {
            return null;
        }

        TipoVehiculo tipoVehiculo = new TipoVehiculo();

        tipoVehiculo.setId( tipoVehiculoDTO.getId() );
        tipoVehiculo.setDes_tipoVehiculo( tipoVehiculoDTO.getDes_tipoVehiculo() );

        return tipoVehiculo;
    }

    protected Marca marcaDTOToMarca(MarcaDTO marcaDTO) {
        if ( marcaDTO == null ) {
            return null;
        }

        Marca marca = new Marca();

        marca.setId( marcaDTO.getId() );
        marca.setDes_marca( marcaDTO.getDes_marca() );

        return marca;
    }

    protected Cliente clienteDTOToCliente(ClienteDTO clienteDTO) {
        if ( clienteDTO == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setId( clienteDTO.getId() );
        cliente.setDni( clienteDTO.getDni() );
        cliente.setNombres( clienteDTO.getNombres() );
        cliente.setApePaterno( clienteDTO.getApePaterno() );
        cliente.setApeMaterno( clienteDTO.getApeMaterno() );
        cliente.setEmail( clienteDTO.getEmail() );

        return cliente;
    }
}
