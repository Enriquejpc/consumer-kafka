package com.training.kafkaconsumer.adapter.kafka;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.kafkaconsumer.adapter.jdbc.JdbcAdapter;
import com.training.kafkaconsumer.adapter.kafka.model.KafkaMessageModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;

@Repository
@Slf4j
public class KafkaAdapter {

    @Autowired
    ObjectMapper objectMapper;
    private final JdbcAdapter jdbcAdapter;

    public KafkaAdapter(JdbcAdapter jdbcAdapter) {
        this.jdbcAdapter = jdbcAdapter;
    }

    @KafkaListener(topics = {"other"})
    public void eventConsumer(ConsumerRecord<String, KafkaMessageModel> message) throws IOException {
        KafkaMessageModel value = objectMapper.convertValue(message.value(), KafkaMessageModel.class);
        log.info("Consumer:: message Received: {} from {}", value, message.topic());
        jdbcAdapter.saveMessage(value.toDomain());
    }
}
