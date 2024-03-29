package com.example.playwithgrpc.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {
    @Value("${kafka.topic-1}")
    private String topic;

    @Bean
    public NewTopic buildEventTopic() {
        return TopicBuilder.name(topic).build();
    }
}
