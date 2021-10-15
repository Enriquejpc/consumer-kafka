package com.training.kafkaconsumer.adapter.jdbc;

import org.springframework.stereotype.Component;

import com.training.kafkaconsumer.adapter.jdbc.model.MessageJdbcModel;
import com.training.kafkaconsumer.domain.Message;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JdbcAdapter {

    private final MessageRepository messageRepository;

    public JdbcAdapter(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void saveMessage(Message domain) {
        MessageJdbcModel messageJdbcModel = MessageJdbcModel.fromDomain(domain);
        log.info("Recording message: {} read from kafka", messageJdbcModel);
        messageRepository.save(messageJdbcModel);
    }
}
