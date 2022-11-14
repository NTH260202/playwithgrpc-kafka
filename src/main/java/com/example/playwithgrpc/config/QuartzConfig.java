package com.example.playwithgrpc.config;

import com.example.playwithgrpc.schedule.SchedulerJobFactory;
import lombok.RequiredArgsConstructor;
import org.quartz.TriggerUtils;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.Properties;

@Configuration
@RequiredArgsConstructor
public class QuartzConfig {
    private final QuartzProperties quartzProperties;

    private final ApplicationContext applicationContext;

    private final SchedulerJobFactory schedulerJobFactory;
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        schedulerJobFactory.setApplicationContext(applicationContext);
        Properties properties = new Properties();
        properties.putAll(quartzProperties.getProperties());

        SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
        scheduler.setQuartzProperties(properties);
        scheduler.setWaitForJobsToCompleteOnShutdown(true);
//        scheduler.setApplicationContextSchedulerContextKey("applicationContext");
        scheduler.setJobFactory(schedulerJobFactory);
        return scheduler;
    }
}
