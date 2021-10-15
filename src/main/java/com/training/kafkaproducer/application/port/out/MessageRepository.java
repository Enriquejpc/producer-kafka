package com.training.kafkaproducer.application.port.out;

import com.training.kafkaproducer.domain.Message;

public interface MessageRepository {
    Boolean send(Message message);

}
