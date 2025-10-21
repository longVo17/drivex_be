package com.example.drivex_be.service;

import com.example.drivex_be.repository.RidePaymentRepository;
import com.example.drivex_be.repository.RideRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RideService {

    private final RideRequestRepository rideRequestRepository;
    private final RidePaymentRepository ridePaymentRepository;

    public void acceptRideRequest(Integer requestId) {
        rideRequestRepository.acceptRideRequest(requestId);
    }

    public void completeRide(Integer rideId, Double cost) {
        ridePaymentRepository.payRide(rideId, LocalDateTime.now(), cost);
    }
}
