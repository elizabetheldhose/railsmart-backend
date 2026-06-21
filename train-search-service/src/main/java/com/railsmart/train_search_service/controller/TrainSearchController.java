package com.railsmart.train_search_service.controller;

import com.railsmart.train_search_service.model.Train;
import com.railsmart.train_search_service.service.TrainSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trains")
@RequiredArgsConstructor
public class TrainSearchController {

    private final TrainSearchService trainSearchService;

    @GetMapping("/search")
    public ResponseEntity<List<Train>> searchTrains(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam String date) {

        List<Train> trains = trainSearchService.searchTrains(from, to);
        return ResponseEntity.ok(trains);
    }
}