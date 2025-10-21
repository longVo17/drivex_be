package com.example.drivex_be.Controller;

import com.example.drivex_be.service.RideService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/pay")
    public ResponseEntity<String> completeRide(
            @RequestParam Integer rideId,
            @RequestParam Double cost
    ) {
        rideService.completeRide(rideId, cost);
        return ResponseEntity.ok("Payment done — Trigger sẽ tự cập nhật rides thành 'completed'");
    }
}
