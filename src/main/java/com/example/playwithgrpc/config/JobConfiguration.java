package com.example.playwithgrpc.config;

import com.example.playwithgrpc.schedule.NotificationJob;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.JobDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class JobConfiguration {
    private static final String SYNCDATAJOB = "syncDataJob";
    private static final String SYNCDATAGROUP = "syncDataGroup";
    private static final String SYNCDATATRIGGER = "syncDataTrigger";

    private final Scheduler scheduler;

    public JobConfiguration(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @PostConstruct
    private void init() throws Exception {
        scheduler.addJob(syncData(), true, true);
    }

    private JobDetail syncData() {
        JobDetailImpl jobDetail = new JobDetailImpl();
        jobDetail.setKey(new JobKey(SYNCDATAJOB, SYNCDATAGROUP));
        jobDetail.setJobClass(NotificationJob.class);
        return jobDetail;
    }
    private Trigger triggerSy
}
