package com.training.kafkaconsumer.adapter.kafka.model;

import java.util.List;

import com.training.kafkaconsumer.domain.Message;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KafkaMessageModel {
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
