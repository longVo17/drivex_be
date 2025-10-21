package com.example.drivex_be.service;

import com.example.drivex_be.model.*;
import com.example.drivex_be.repository.RidePaymentRepository;
import com.example.drivex_be.repository.RideRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RideService {

    private final RideRequestRepository rideRequestRepository;
    private final RidePaymentRepository ridePaymentRepository;

    public void acceptRideRequest(Integer requestId) {
        rideRequestRepository.acceptRideRequest(requestId);
    }

    public RidePayment addPayment(Integer rideId, Integer paymentId, BigDecimal cost) {
        RidePayment ridePayment = new RidePayment();
        RidePaymentId id = new RidePaymentId(rideId, paymentId);
        ridePayment.setId(id);
        ridePayment.setRide(new Ride()); ridePayment.getRide().setRideId(rideId);
        ridePayment.setPayment(new Payment()); ridePayment.getPayment().setPaymentId(paymentId);
        ridePayment.setPayTime(LocalDateTime.now());
        ridePayment.setCost(cost);
        return ridePaymentRepository.save(ridePayment);
    }
}
