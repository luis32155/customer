package com.exercise.customer.configuration;

import com.exercise.customer.util.Constante;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.kafka.clients.admin.NewTopic;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic clienteTopic() {
        return new NewTopic(Constante.CLIENTE_TOPIC, 1, (short) 1);
    }
}
