package com.training.kafkaconsumer.domain;

import java.util.List;

import lombok.Builder;
import lombok.Value;
import lombok.With;

@Value
@Builder
public class Message {
    private String title;
    private String content;
    private List<String> email;
    @With
    private boolean sent;
}
