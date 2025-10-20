package com.example.drivex_be.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "rides")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rideId")
    private Integer rideId;

    @ManyToOne
    @JoinColumn(name = "driverId")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @Column(name = "pickUpPosition", length = 255)
    private String pickUpPosition;

    @Column(name = "destination", length = 255)
    private String destination;

    @Column(name = "startTime")
    private LocalDateTime startTime;

    @Column(name = "endTime")
    private LocalDateTime endTime;


    @Column(name = "status", length = 20, columnDefinition = "VARCHAR(20) DEFAULT 'ongoing' CHECK (status IN ('ongoing', 'completed', 'cancelled'))")
    private String status;

    @OneToOne
    @JoinColumn(name = "feedbackId")
    private Feedback feedback;
}