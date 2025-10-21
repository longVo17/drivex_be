package com.example.drivex_be.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RidePaymentId {
    private Integer rideId;
    private Integer paymentId;
}
