package com.training.kafkaconsumer.adapter.jdbc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.training.kafkaconsumer.adapter.kafka.model.KafkaMessageModel;
import com.training.kafkaconsumer.domain.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class MessageJdbcModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;
    private String content;
    @ElementCollection
    private List<String> email;

    public static MessageJdbcModel fromDomain(Message message){
        return MessageJdbcModel.builder()
            .title(message.getTitle())
            .content(message.getContent())
            .email(message.getEmail())
            .build();
    }
}
