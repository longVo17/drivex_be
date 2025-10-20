package com.example.drivex_be.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RideRequestDTO {
    private Long id;
    private Long customerId;
    private Long driverId;
    private String pickupLocation;
    private String dropoffLocation;
    private LocalDateTime requestTime;
    private String status;

    public RideRequestDTO(Long id, Long customerId, Long driverId, String pickupLocation, String dropoffLocation, LocalDateTime requestTime, String status) {
        this.id = id;
        this.customerId = customerId;
        this.driverId = driverId;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.requestTime = requestTime;
        this.status = status;
    }
}