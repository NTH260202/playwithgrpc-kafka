package com.example.playwithgrpc;

import com.example.playwithgrpc.config.QuartzConfig;
import com.example.playwithgrpc.repository.EventStore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = EventStore.class)
@EnableJpaRepositories(basePackages = {"com.example.playwithgrpc.repository.jpa"})
public class PlaywithgrpcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlaywithgrpcApplication.class, args);
    }


}
