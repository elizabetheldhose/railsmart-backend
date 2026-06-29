package com.railsmart.alert_service.service;

import com.railsmart.alert_service.model.SeatAlert;
import com.railsmart.alert_service.repository.AlertRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AlertService {

    private final AlertRepository alertRepository;
    private final JavaMailSender mailSender;

    public SeatAlert createAlert(SeatAlert alert) {
        alert.setNotified(false);
        return alertRepository.save(alert);
    }

    public void processAlerts() {
        List<SeatAlert> pendingAlerts = alertRepository.findByNotifiedFalse();
        log.info("Processing {} pending alerts", pendingAlerts.size());

        for (SeatAlert alert : pendingAlerts) {
            // In real world — check actual seat availability here
            // For now we simulate seats are available
            boolean seatsAvailable = checkSeatsAvailable(alert.getTrainNumber());

            if (seatsAvailable) {
                sendEmail(alert);
                alert.setNotified(true);
                alertRepository.save(alert);
                log.info("Alert sent to {}", alert.getUserEmail());
            }
        }
    }

    private boolean checkSeatsAvailable(String trainNumber) {
        // Simulate — in real world call train-search-service
        return true;
    }

    private void sendEmail(SeatAlert alert) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(alert.getUserEmail());
        message.setSubject("🚂 Seat Available! Train " + alert.getTrainNumber());
        message.setText(
                "Good news! Seats are now available for your journey.\n\n" +
                        "Train: " + alert.getTrainNumber() + "\n" +
                        "From: " + alert.getSource() + "\n" +
                        "To: " + alert.getDestination() + "\n" +
                        "Date: " + alert.getJourneyDate() + "\n\n" +
                        "Book now before seats fill up!"
        );
        mailSender.send(message);
    }
}