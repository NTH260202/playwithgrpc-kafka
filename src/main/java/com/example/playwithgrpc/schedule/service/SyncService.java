package com.example.playwithgrpc.schedule.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SyncService {
    public void start() {
        log.info("Job service ...");
    }
}
