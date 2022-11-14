//package com.example.playwithgrpc.schedule;
//
//import com.example.playwithgrpc.schedule.service.SyncService;
//import lombok.RequiredArgsConstructor;
//import org.quartz.Job;
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//import org.quartz.SchedulerException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.stereotype.Component;
//
//@RequiredArgsConstructor
//@Component
//public class SyncJob implements Job {
//    private final SyncService syncService;
//    @Override
//    public void execute(JobExecutionContext jobContext) {
//        try {
//            ApplicationContext context = getContext(jobContext);
//            syncService.start();
//        } catch (SchedulerException e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
//
//    private ApplicationContext getContext(JobExecutionContext jobContext) throws SchedulerException {
//        ApplicationContext context = (ApplicationContext) jobContext.getScheduler().getContext().get("applicationContext");
//        if (context == null) {
//            throw new JobExecutionException("No application context in scheduler context.");
//        }
//        return context;
//    }
//}
