package com.training.kafkaproducer.adapter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.kafkaproducer.adapter.controller.model.MessageRequestBody;
import com.training.kafkaproducer.application.port.in.CreateMessageCommand;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/message")
public class MessageController {

    CreateMessageCommand createMessageCommand;

    public MessageController(CreateMessageCommand createMessageCommand) {
        this.createMessageCommand = createMessageCommand;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody MessageRequestBody body){
        log.info("Producer:: message received {}", body);
        createMessageCommand.execute(body.toDomain());
        return ResponseEntity.status(HttpStatus.CREATED).body("Message received and sent. Adios amigo!");
    }
}
