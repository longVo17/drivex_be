package com.example.drivex_be.Controller;

import com.example.drivex_be.model.RidePayment;
import com.example.drivex_be.service.RideService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/rides")
@RequiredArgsConstructor
public class RideController {

    private final RideService rideService;

    @PutMapping("/accept/{requestId}")
    public ResponseEntity<String> acceptRideRequest(@PathVariable Integer requestId) {
        rideService.acceptRideRequest(requestId);
        return ResponseEntity.ok("Ride request accepted — Trigger sẽ tự tạo chuyến đi trong bảng rides");
    }


    @PostMapping("/add")
    public ResponseEntity<RidePayment> addPayment(
            @RequestParam Integer rideId,
            @RequestParam Integer paymentId,
            @RequestParam BigDecimal cost) {
        RidePayment payment = rideService.addPayment(rideId, paymentId, cost);
        return ResponseEntity.ok(payment);
    }
}
