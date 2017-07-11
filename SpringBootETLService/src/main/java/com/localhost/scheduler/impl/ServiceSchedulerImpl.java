package com.localhost.scheduler.impl;

import com.localhost.scheduler.ServiceScheduler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;

/**
 * Created by o.serohin on 11.07.2017.
 */
@Slf4j
@Component
public class ServiceSchedulerImpl implements ServiceScheduler {
    @Value("${file.path}")
    private String filePathString;

    @Scheduled(cron = "0 * * * * *")
    public void scheduleServices() {
        File file = new File(filePathString);
        System.out.println("Test " + LocalDateTime.now());
    }
}
