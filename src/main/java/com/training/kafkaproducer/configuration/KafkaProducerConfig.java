package com.training.kafkaproducer.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import org.apache.kafka.clients.admin.NewTopic;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public NewTopic newTopic() {
        return TopicBuilder.name("other").partitions(1).replicas(1).build();
    }
}
