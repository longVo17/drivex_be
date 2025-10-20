package com.example.drivex_be.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RideDTO {
    private Long rideId;
    private Long driverId;
    private Long customerId;
    private String pickUpPosition;
    private String destination;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;

    public RideDTO(Long rideId, Long driverId, Long customerId, String pickUpPosition, String destination, LocalDateTime startTime, LocalDateTime endTime, String status) {
        this.rideId = rideId;
        this.driverId = driverId;
        this.customerId = customerId;
        this.pickUpPosition = pickUpPosition;
        this.destination = destination;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }
}