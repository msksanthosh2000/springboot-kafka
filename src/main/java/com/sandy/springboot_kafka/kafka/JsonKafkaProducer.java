package com.sandy.springboot_kafka.kafka;

import com.sandy.springboot_kafka.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public void sendMsg(User user){

        LOGGER.info(String.format("Message Sent -> %s", user.toString()));

        // build message
        Message<User> message = MessageBuilder
                .withPayload(user)
                        .setHeader(KafkaHeaders.TOPIC, "topicone_json")
                                .build();

        kafkaTemplate.send(message);
    }

}
