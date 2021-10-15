package com.training.kafkaproducer.adapter.controller.model;

import java.util.List;

import com.training.kafkaproducer.domain.Message;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MessageRequestBody {
    private String title;
    private String content;
    private List<String> email;

    public Message toDomain(){
        return Message.builder()
            .title(title)
            .content(content)
            .email(email)
            .build();
    }
}
