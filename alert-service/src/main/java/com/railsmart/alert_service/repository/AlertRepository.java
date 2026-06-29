package com.railsmart.alert_service.repository;

import com.railsmart.alert_service.model.SeatAlert;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertRepository extends MongoRepository<SeatAlert, String> {
    List<SeatAlert> findByNotifiedFalse();
}