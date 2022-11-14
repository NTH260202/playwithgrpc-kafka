package com.example.playwithgrpc.config;

import com.example.playwithgrpc.schedule.JobScheduleCreator;
import com.example.playwithgrpc.schedule.NotificationJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.core.QuartzSchedulerResources;
import org.quartz.impl.JobDetailImpl;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Configuration
@Slf4j
public class JobConfiguration {
    private static final String SYNCDATAJOB = "syncDataJob";
    private static final String SYNCDATAGROUP = "syncDataGroup";
    private static final String SYNCDATATRIGGER = "syncDataTrigger";

    private final QuartzProperties quartzProperties;
    private final ApplicationContext applicationContext;
    private final JobScheduleCreator jobScheduleCreator;

    private final Scheduler scheduler;

    public JobConfiguration(QuartzProperties quartzProperties, ApplicationContext applicationContext, JobScheduleCreator jobScheduleCreator, Scheduler scheduler) {
        this.quartzProperties = quartzProperties;
        this.applicationContext = applicationContext;
        this.jobScheduleCreator = jobScheduleCreator;
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
        try {

            Trigger trigger = scheduler.getTrigger(new TriggerKey(SYNCDATATRIGGER, SYNCDATAGROUP));

            JobDetail jobDetail = scheduler.getJobDetail(new JobKey(SYNCDATAJOB, SYNCDATATRIGGER));

            if (jobDetail == null) {

                jobDetail = jobScheduleCreator.createJob(NotificationJob.class, true, applicationContext,
                        SYNCDATATRIGGER, SYNCDATAGROUP);
                scheduler.addJob(jobDetail, true);

            } else {
                log.error("scheduleNewJobRequest.jobAlreadyExist");
            }

            if (trigger == null) {
                LocalDateTime time = LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()).plusMinutes(1);
                Date startTime =  Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
                log.info("Start time trigger: " + startTime);
                trigger = jobScheduleCreator.createSimpleTrigger(SYNCDATATRIGGER, SYNCDATAGROUP,
                       startTime, 5000L, 2,
                        SimpleTrigger.MISFIRE_INSTRUCTION_RESCHEDULE_NOW_WITH_EXISTING_REPEAT_COUNT, jobDetail);

                scheduler.scheduleJob(trigger);
                scheduler.start();
            } else {
                scheduler.start();
            }
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
        }
    }
}
