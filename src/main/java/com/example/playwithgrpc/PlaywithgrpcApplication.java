package com.example.playwithgrpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = {"com.example.playwithgrpc.model.event"})
public class PlaywithgrpcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlaywithgrpcApplication.class, args);
    }


}
