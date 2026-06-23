package com.railsmart.pnr_service.service;

import com.railsmart.pnr_service.model.PnrBooking;
import com.railsmart.pnr_service.repository.PnrRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class PnrService {

    private final PnrRepository pnrRepository;

    public PnrBooking createBooking(PnrBooking booking) {
        // Generate unique PNR number
        booking.setPnrNumber(generatePnr());
        booking.setBookingStatus("CONFIRMED");
        return pnrRepository.save(booking);
    }

    public Optional<PnrBooking> getByPnr(String pnrNumber) {
        return pnrRepository.findByPnrNumber(pnrNumber);
    }

    private String generatePnr() {
        return String.valueOf(1000000000L + new Random().nextInt(900000000));
    }
}