package com.training.kafkaproducer.adapter.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Repository;

import com.training.kafkaproducer.adapter.kafka.model.KafkaMessageModel;
import com.training.kafkaproducer.application.port.out.MessageRepository;
import com.training.kafkaproducer.domain.Message;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class KafkaAdapter implements MessageRepository {

    @Autowired
    KafkaTemplate<String, KafkaMessageModel> kafkaTemplate;

    @Override
    public Boolean send(Message message) {
        KafkaMessageModel messageModel = KafkaMessageModel.fromDomain(message);
        log.info("Transformed from domain: {}", messageModel);
        kafkaTemplate.send("other", messageModel);
        kafkaTemplate.flush();
        return true;
    }
}
