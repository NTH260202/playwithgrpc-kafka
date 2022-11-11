package com.example.playwithgrpc.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.Properties;

@Configuration
@RequiredArgsConstructor
public class QuartzConfig {
    private final QuartzProperties quartzProperties;
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        Properties properties = new Properties();
        properties.putAll(quartzProperties.getProperties());

        SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
        scheduler.setQuartzProperties(properties);
        scheduler.setWaitForJobsToCompleteOnShutdown(true);
        scheduler.setApplicationContextSchedulerContextKey("applicationContext");
        return scheduler;
    }
}
