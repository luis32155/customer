package com.exercise.customer.service;

import com.exercise.customer.dto.ClienteDTO;

import java.util.List;

public interface  ClienteService {

    ClienteDTO saveCliente(ClienteDTO clienteDTO);
    List<ClienteDTO> getAllClientes();
    ClienteDTO getClienteById(Long id);
    void deleteCliente(Long id);
}
