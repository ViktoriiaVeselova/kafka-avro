package com.epam.kafkaavro.producer;

import com.epam.kafkaavro.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Producer {

    @Value("${topic.name}")
    private String topic;

    @Autowired
    private  KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User user) {
        kafkaTemplate.send(this.topic, user.getName(), user);
        log.info(String.format("Produced user -> %s", user));
    }
}
