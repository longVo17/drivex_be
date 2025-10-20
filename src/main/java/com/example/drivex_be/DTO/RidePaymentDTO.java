package com.example.drivex_be.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RidePaymentDTO {
    private Long rideId;
    private Long paymentId;
    private LocalDateTime payTime;
    private Double cost;

    public RidePaymentDTO(Long rideId, Long paymentId, LocalDateTime payTime, Double cost) {
        this.rideId = rideId;
        this.paymentId = paymentId;
        this.payTime = payTime;
        this.cost = cost;
    }
}