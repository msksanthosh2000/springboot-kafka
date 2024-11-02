package com.sandy.springboot_kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic getNewKafkaTopic(){
        return TopicBuilder.name("topicone").build();
    }

    @Bean
    public NewTopic getNewKafkaTopicForJson(){
        return TopicBuilder.name("topicone_json").build();
    }

}
