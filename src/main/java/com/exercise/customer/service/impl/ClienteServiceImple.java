package com.exercise.customer.service.impl;

import com.exercise.customer.dto.ClienteDTO;
import com.exercise.customer.entity.Cliente;
import com.exercise.customer.exception.ResourceNotFoundException;
import com.exercise.customer.mapper.ClienteMapper;
import com.exercise.customer.repository.ClienteRepository;
import com.exercise.customer.service.ClienteService;
import com.exercise.customer.service.KafkaProducerService;
import com.exercise.customer.util.Constante;
import lombok.RequiredArgsConstructor;
import org.aspectj.apache.bcel.classfile.Constant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteServiceImple implements ClienteService {

    private final ClienteRepository clienteRepository;

    private final ClienteMapper clienteMapper;

    private final KafkaProducerService kafkaProducerService;

    @Override
    public ClienteDTO saveCliente(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.toEntity(Optional.of(clienteDTO)).orElseThrow();
        Cliente savedCliente = clienteRepository.save(cliente);
        ClienteDTO savedClienteDTO = clienteMapper.toDTO(Optional.of(savedCliente)).orElseThrow();
        kafkaProducerService.sendClienteEvent(savedClienteDTO);

        return savedClienteDTO;
    }

    @Override
    public List<ClienteDTO> getAllClientes() {
        return clienteRepository.findAll().stream()
                .map(cliente -> clienteMapper.toDTO(Optional.of(cliente)).orElseThrow())
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO getClienteById(Long id) {
        return clienteRepository.findById(id)
                .map(cliente -> clienteMapper.toDTO(Optional.of(cliente)).orElseThrow())
                .orElseThrow(() -> new ResourceNotFoundException(Constante.ERROR_CLIENTE_NO_ENCONTRADO));
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
