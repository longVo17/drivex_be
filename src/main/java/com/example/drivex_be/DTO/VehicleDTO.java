package com.example.drivex_be.DTO;

import lombok.Data;

@Data
public class VehicleDTO {
    private Long vehicleId;
    private String vehicleType;
    private String vehicleName;
    private String vehicleNumber;
    private Long driverId;

    public VehicleDTO(Long vehicleId, String vehicleType, String vehicleName, String vehicleNumber, Long driverId) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.vehicleName = vehicleName;
        this.vehicleNumber = vehicleNumber;
        this.driverId = driverId;
    }
}