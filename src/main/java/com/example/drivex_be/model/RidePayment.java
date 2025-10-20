package com.example.drivex_be.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ride_payment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RidePayment {
    @EmbeddedId
    public RidePaymentId id;

    @ManyToOne
    @MapsId("rideId")
    @JoinColumn(name = "rideId")
    private Ride ride;

    @ManyToOne
    @MapsId("paymentId")
    @JoinColumn(name = "paymentId")
    private Payment payment;

    @Column(name = "payTime", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime payTime;

    @Column(name = "cost", columnDefinition = "NUMERIC(10,2)")
    private BigDecimal cost; // Thay Double bằng BigDecimal
}

