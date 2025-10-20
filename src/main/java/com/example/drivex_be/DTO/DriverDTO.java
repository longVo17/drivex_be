package com.example.drivex_be.DTO;

import lombok.Data;

@Data
public class DriverDTO {
    private Long driverId;
    private String name;
    private String phone;
    private String email;
    private Double rating;

    public DriverDTO(Long driverId, String name, String phone, String email, Double rating) {
        this.driverId = driverId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.rating = rating;
    }
}