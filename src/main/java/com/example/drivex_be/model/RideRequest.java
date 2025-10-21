package com.example.drivex_be.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "ride_requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;


    @Column(name = "pickup_location", length = 255)
    private String pickupLocation;

    @Column(name = "dropoff_location", length = 255)
    private String dropoffLocation;

    @Column(name = "request_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime requestTime;

    @Column(name = "status", length = 20, columnDefinition = "VARCHAR(20) DEFAULT 'pending' CHECK (status IN ('pending', 'accepted', 'cancelled', 'expired'))")
    private String status;
}