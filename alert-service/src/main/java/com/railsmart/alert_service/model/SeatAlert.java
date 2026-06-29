package com.railsmart.alert_service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "seat_alerts")
public class SeatAlert {

    @Id
    private String id;
    private String trainNumber;
    private String source;
    private String destination;
    private String journeyDate;
    private String userEmail;
    private boolean notified; // true = email already sent
}