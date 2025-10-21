package com.example.drivex_be.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "feedback")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer feedbackId;

    @OneToOne
    @JoinColumn(name = "rideId", unique = true)
    private Ride ride;

    @ManyToOne
    @JoinColumn(name = "driverId", nullable = false)
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;


    @Column(name = "review", columnDefinition = "TEXT")
    private String review;

    @Column(name = "rating", columnDefinition = "INT CHECK (rating BETWEEN 1 AND 5)")
    private Integer rating;
}