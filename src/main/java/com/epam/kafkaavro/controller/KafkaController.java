package com.epam.kafkaavro.controller;

import com.epam.kafkaavro.User;
import com.epam.kafkaavro.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class KafkaController {
    @Autowired
    private Producer producer;


    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        producer.sendMessage(new User(name, age));
    }
}
