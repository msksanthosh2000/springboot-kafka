package com.sandy.springboot_kafka.controller;

import com.sandy.springboot_kafka.dto.User;
import com.sandy.springboot_kafka.kafka.JsonKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    @Autowired
    private JsonKafkaProducer jsonKafkaProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        jsonKafkaProducer.sendMsg(user);

        return ResponseEntity.ok("json msg sent");
    }
}
