package com.example.drivex_be.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DriverLocationDTO {
    private Long driverId;
    private Double latitude;
    private Double longitude;
    private LocalDateTime updatedAt;

    public DriverLocationDTO(Long driverId, Double latitude, Double longitude, LocalDateTime updatedAt) {
        this.driverId = driverId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.updatedAt = updatedAt;
    }
}