package com.railsmart.train_search_service.config;

import com.railsmart.train_search_service.model.Train;
import com.railsmart.train_search_service.repository.TrainRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataSeeder implements CommandLineRunner {

    private final TrainRepository trainRepository;

    @Override
    public void run(String... args) {

        if (trainRepository.count() > 0) {
            log.info("Data already seeded — skipping.");
            return;
        }

        List<Train> trains = List.of(
                createTrain("12649", "SAMPARK KRANTI EXP", "NDLS", "MAS", "20:30", "08:30", 120, "SUPERFAST"),
                createTrain("12433", "RAJDHANI EXPRESS", "NDLS", "MAS", "06:00", "18:00", 80, "RAJDHANI"),
                createTrain("12621", "TAMIL NADU EXP", "NDLS", "MAS", "22:30", "07:40", 200, "SUPERFAST"),
                createTrain("22691", "RAJDHANI EXPRESS", "NDLS", "SBC", "20:00", "05:45", 60, "RAJDHANI"),
                createTrain("12627", "KARNATAKA EXPRESS", "NDLS", "SBC", "21:30", "10:30", 150, "SUPERFAST"),
                createTrain("12657", "BANGALORE MAIL", "MAS", "SBC", "23:00", "05:30", 180, "MAIL"),
                createTrain("12028", "SHATABDI EXPRESS", "SBC", "MAS", "06:00", "11:00", 90, "SHATABDI"),
                createTrain("12639", "BRINDAVAN EXPRESS", "MAS", "SBC", "07:45", "13:30", 210, "EXPRESS"),
                createTrain("12779", "GOA EXPRESS", "SBC", "NDLS", "11:00", "08:30", 100, "EXPRESS"),
                createTrain("16527", "UDYAN EXPRESS", "SBC", "MAS", "21:40", "05:45", 175, "EXPRESS"),
                createTrain("12431", "RAJDHANI EXPRESS", "NDLS", "HWH", "16:55", "10:05", 70, "RAJDHANI"),
                createTrain("12301", "HOWRAH RAJDHANI", "HWH", "NDLS", "14:05", "09:55", 85, "RAJDHANI"),
                createTrain("12303", "POORVA EXPRESS", "HWH", "NDLS", "08:45", "06:00", 160, "SUPERFAST"),
                createTrain("12259", "DURONTO EXPRESS", "NDLS", "HWH", "08:15", "23:59", 55, "DURONTO"),
                createTrain("12951", "MUMBAI RAJDHANI", "NDLS", "MMCT", "16:55", "08:35", 75, "RAJDHANI"),
                createTrain("12953", "AUGUST KRANTI EXP", "NDLS", "MMCT", "17:40", "10:55", 130, "SUPERFAST"),
                createTrain("12137", "PUNJAB MAIL", "MMCT", "FZR", "19:10", "05:45", 190, "MAIL"),
                createTrain("12263", "DURONTO EXPRESS", "MMCT", "NDLS", "23:00", "15:55", 65, "DURONTO"),
                createTrain("12723", "TELANGANA EXPRESS", "HYB", "NDLS", "06:25", "10:20", 140, "SUPERFAST"),
                createTrain("12707", "AP EXPRESS", "HYB", "NDLS", "06:50", "10:40", 155, "SUPERFAST")
        );

        trainRepository.saveAll(trains);
        log.info("✅ Seeded {} trains into MongoDB.", trains.size());
    }

    private Train createTrain(String number, String name, String source,
                              String destination, String departure,
                              String arrival, int seats, String type) {
        Train train = new Train();
        train.setTrainNumber(number);
        train.setTrainName(name);
        train.setSource(source);
        train.setDestination(destination);
        train.setDepartureTime(departure);
        train.setArrivalTime(arrival);
        train.setAvailableSeats(seats);
        train.setTrainType(type);
        return train;
    }
}