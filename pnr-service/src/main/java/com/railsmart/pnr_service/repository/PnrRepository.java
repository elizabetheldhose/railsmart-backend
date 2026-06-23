package com.railsmart.pnr_service.repository;

import com.railsmart.pnr_service.model.PnrBooking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PnrRepository extends MongoRepository<PnrBooking, String> {
    Optional<PnrBooking> findByPnrNumber(String pnrNumber);
}