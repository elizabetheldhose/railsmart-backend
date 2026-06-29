package com.railsmart.train_search_service.service;

import com.railsmart.train_search_service.model.Train;
import com.railsmart.train_search_service.repository.TrainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainSearchService {

    private final TrainRepository trainRepository;

//    @Cacheable(value = "trains", key = "#from + '-' + #to")
    public List<Train> searchTrains(String from, String to) {
        return trainRepository.findBySourceAndDestination(from, to);
    }
}