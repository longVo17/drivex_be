package com.example.drivex_be.DTO;

import lombok.Data;

@Data
public class PaymentDTO {
    private Long paymentId;
    private String paymentName;

    public PaymentDTO(Long paymentId, String paymentName) {
        this.paymentId = paymentId;
        this.paymentName = paymentName;
    }
}