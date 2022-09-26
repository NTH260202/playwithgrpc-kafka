//package com.example.playwithgrpc.service.kafka;
//
//import com.example.playwithgrpc.model.entity.Account;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//@Component
//@Slf4j
//public class KafkaListenerImpl {
//
//    @KafkaListener(topics = "test-topic",
//            groupId = "test-group",
//            containerFactory = "kafkaListenerContainerFactory")
//    void listener(String data) {
//        log.info(data);
//    }
//}
