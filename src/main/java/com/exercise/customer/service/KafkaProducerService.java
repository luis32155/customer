package com.exercise.customer.service;

import com.exercise.customer.dto.ClienteDTO;
import com.exercise.customer.util.Constante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, ClienteDTO> kafkaTemplate;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, ClienteDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendClienteEvent(ClienteDTO clienteDTO) {
        kafkaTemplate.send(Constante.CLIENTE_TOPIC, clienteDTO);
    }
}
