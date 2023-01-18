package com.epam.kafkaavro.consumer;

import com.epam.kafkaavro.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer {

    @KafkaListener(topics = "users", groupId = "group_id")
    public void consume(ConsumerRecord<String, User> userRecord) {
        log.info(String.format("Consumed message -> %s", userRecord.value()));
    }
}

