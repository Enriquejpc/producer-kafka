package com.training.kafkaproducer.application.port.in;

import com.training.kafkaproducer.domain.Message;

public interface CreateMessageCommand {

    Message execute(Message message);
}
