package com.railsmart.pnr_service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@Document(collection = "pnr_bookings")
public class PnrBooking {

    @Id
    private String id;

    @Indexed(unique = true)
    private String pnrNumber;

    private String trainNumber;
    private String trainName;
    private String source;
    private String destination;
    private String journeyDate;
    private String departureTime;
    private String arrivalTime;
    private String passengerName;
    private int passengerAge;
    private String seatNumber;
    private String bookingStatus; // CONFIRMED, WAITING, CANCELLED
}