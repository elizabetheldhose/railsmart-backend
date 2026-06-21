package com.railsmart.train_search_service.repository;

import com.railsmart.train_search_service.model.Train;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainRepository extends MongoRepository<Train, String> {
    List<Train> findBySourceAndDestination(String source, String destination);
}