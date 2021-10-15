package com.training.kafkaconsumer.adapter.jdbc;

import org.springframework.data.repository.CrudRepository;

import com.training.kafkaconsumer.adapter.jdbc.model.MessageJdbcModel;

public interface MessageRepository extends CrudRepository<MessageJdbcModel, Long> {

}
