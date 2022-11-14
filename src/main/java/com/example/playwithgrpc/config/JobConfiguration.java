package com.example.playwithgrpc.config;

import com.example.playwithgrpc.schedule.NotificationJob;
import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import javax.annotation.PostConstruct;
import java.util.Properties;

@Configuration
public class JobConfiguration {
    private static final String SYNCDATAJOB = "syncDataJob";
    private static final String SYNCDATAGROUP = "syncDataGroup";
    private static final String SYNCDATATRIGGER = "syncDataTrigger";
    private static QuartzProperties quartzProperties;

    private final Scheduler scheduler;

    public JobConfiguration(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

//    @Bean
//    public SchedulerFactoryBean schedulerFactoryBean() {
//
////        JobFactory jobFactory = new JobFactory();
////        jobFactory.setApplicationContext(applicationContext);
////
////        Properties properties = new Properties();
////        properties.putAll(quartzProperties.getProperties());
////
////        SchedulerFactoryBean factory = new SchedulerFactoryBean();
////        factory.setOverwriteExistingJobs(true);
////        factory.setDataSource(dataSource);
////        factory.setQuartzProperties(properties);
////        factory.setJobFactory(jobFactory);
////        return factory;
//        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
//        Properties properties = new Properties();
//        properties.putAll(quartzProperties.getProperties());
//        schedulerFactoryBean.setQuartzProperties(properties);
//        schedulerFactoryBean.setWaitForJobsToCompleteOnShutdown(true);
//        schedulerFactoryBean.setApplicationContextSchedulerContextKey("applicationContext");
//        return schedulerFactoryBean;
//    }

    @PostConstruct
    private void init() throws Exception {
        scheduler.addJob(syncData(), true, true);
        if (!scheduler.checkExists(new TriggerKey(SYNCDATATRIGGER, SYNCDATAGROUP))) {
            scheduler.scheduleJob(triggerSyncData());
        }
    }

    private JobDetail syncData() {
        JobDetailImpl jobDetail = new JobDetailImpl();
        jobDetail.setKey(new JobKey(SYNCDATAJOB, SYNCDATAGROUP));
        jobDetail.setJobClass(NotificationJob.class);
        return jobDetail;
    }
    private Trigger triggerSyncData() {
        return TriggerBuilder.newTrigger()
                .forJob(syncData())
                .withIdentity(SYNCDATATRIGGER, SYNCDATAGROUP)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMilliseconds(1000L).repeatForever())
                .build();
    }
}
