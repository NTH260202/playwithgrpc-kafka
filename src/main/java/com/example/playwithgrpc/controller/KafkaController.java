package com.example.playwithgrpc.controller;

import com.example.playwithgrpc.model.entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messgae")
@Slf4j
public class KafkaController {
//    @Autowired
//    private ConcurrentKafkaListenerContainerFactory<String, Account> factory;


    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public String sendMessage(@RequestParam String message){
        try {
            kafkaTemplate.send("topic-test", message);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return "Json message is sent successfully";
    }



}
