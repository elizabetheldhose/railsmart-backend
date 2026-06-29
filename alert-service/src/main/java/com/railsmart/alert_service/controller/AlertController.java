package com.railsmart.alert_service.controller;

import com.railsmart.alert_service.model.SeatAlert;
import com.railsmart.alert_service.service.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alerts")
@RequiredArgsConstructor
public class AlertController {

    private final AlertService alertService;

    @PostMapping("/create")
    public ResponseEntity<SeatAlert> createAlert(@RequestBody SeatAlert alert) {
        SeatAlert saved = alertService.createAlert(alert);
        return ResponseEntity.ok(saved);
    }
}