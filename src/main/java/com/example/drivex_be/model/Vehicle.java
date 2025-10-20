package com.example.drivex_be.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicleId")
    private Integer vehicleId;

    @Column(name = "vehicleType", length = 50)
    private String vehicleType;

    @Column(name = "vehicleName", length = 100)
    private String vehicleName;

    @ManyToOne
    @JoinColumn(name = "driverId", nullable = false)
    private Driver driver;
}