package com.railsmart.train_search_service.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "trains")
public class Train {

    @Id
    private String id;
    private String trainNumber;
    private String trainName;
    private String source;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private int availableSeats;
    private String trainType; // EXPRESS, SUPERFAST, LOCAL
}