package com.example.playwithgrpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@EnableCaching
public class PlaywithgrpcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlaywithgrpcApplication.class, args);
    }


}
