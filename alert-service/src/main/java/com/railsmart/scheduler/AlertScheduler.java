package com.railsmart.alert_service.scheduler;

import com.railsmart.alert_service.service.AlertService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@RequiredArgsConstructor
@Slf4j
public class AlertScheduler {

    private final AlertService alertService;

    // Runs every 5 minutes
    @Scheduled(fixedRate = 300000)
    public void checkAlerts() {
        log.info("⏰ Scheduler running — checking pending alerts...");
        alertService.processAlerts();
    }
}