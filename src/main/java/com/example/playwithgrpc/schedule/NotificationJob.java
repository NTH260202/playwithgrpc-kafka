package com.example.playwithgrpc.schedule;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
@DisallowConcurrentExecution
public class NotificationJob extends QuartzJobBean {
    @Override
    public void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("Send notification!");
    }
}
