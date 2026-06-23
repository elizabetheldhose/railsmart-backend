package com.railsmart.pnr_service.controller;

import com.railsmart.pnr_service.model.PnrBooking;
import com.railsmart.pnr_service.service.PnrService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pnr")
@RequiredArgsConstructor
public class PnrController {

    private final PnrService pnrService;

    // Create a booking
    @PostMapping("/book")
    public ResponseEntity<PnrBooking> book(@RequestBody PnrBooking booking) {
        PnrBooking saved = pnrService.createBooking(booking);
        return ResponseEntity.ok(saved);
    }

    // Check PNR status
    @GetMapping("/{pnrNumber}")
    public ResponseEntity<PnrBooking> checkPnr(@PathVariable String pnrNumber) {
        return pnrService.getByPnr(pnrNumber)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}