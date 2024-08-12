package com.exercise.customer.mapper;

import com.exercise.customer.dto.ClienteDTO;
import com.exercise.customer.entity.Cliente;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClienteMapper {

    public Optional<ClienteDTO> toDTO(Optional<Cliente> cliente) {
        return cliente.map(c -> ClienteDTO.builder()
                .nombre(c.getNombre())
                .genero(c.getGenero())
                .edad(c.getEdad())
                .identificacion(c.getIdentificacion())
                .direccion(c.getDireccion())
                .telefono(c.getTelefono())
                .clienteId(String.valueOf(c.getClienteId()))
                .contrasena(c.getContrasena())
                .estado(c.isEstado())
                .build());
    }

    public Optional<Cliente> toEntity(Optional<ClienteDTO> clienteDTO) {
        return clienteDTO.map(dto -> Cliente.builder()
                .nombre(dto.getNombre())
                .genero(dto.getGenero())
                .edad(dto.getEdad())
                .identificacion(dto.getIdentificacion())
                .direccion(dto.getDireccion())
                .telefono(dto.getTelefono())
                .clienteId(Long.valueOf(dto.getClienteId()))
                .contrasena(dto.getContrasena())
                .estado(dto.isEstado())
                .build());
    }
}
