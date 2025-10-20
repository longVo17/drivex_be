package com.example.drivex_be.DTO;

import lombok.Data;

@Data
public class CustomerDTO {
    private Long customerId;
    private String name;
    private String phone;
    private String email;

    public CustomerDTO(Long customerId, String name, String phone, String email) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}