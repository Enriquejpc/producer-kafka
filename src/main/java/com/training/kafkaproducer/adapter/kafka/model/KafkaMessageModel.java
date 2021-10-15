package com.training.kafkaproducer.adapter.kafka.model;

import java.util.List;

import com.training.kafkaproducer.domain.Message;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KafkaMessageModel {
    private String title;
    private String content;
    private List<String> email;

    public static KafkaMessageModel fromDomain(Message message){
        return KafkaMessageModel.builder()
            .title(message.getTitle())
            .content(message.getContent())
            .email(message.getEmail())
            .build();
    }
}
