package com.training.kafkaproducer.application.usecase;

import org.springframework.stereotype.Service;

import com.training.kafkaproducer.application.port.in.CreateMessageCommand;
import com.training.kafkaproducer.application.port.out.MessageRepository;
import com.training.kafkaproducer.domain.Message;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SendMessageUseCase implements CreateMessageCommand {

    MessageRepository messageRepository;

    public SendMessageUseCase(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message execute(Message message) {
        log.info("Processing: {}", message);
        return message.withSent(messageRepository.send(message));
    }
}
