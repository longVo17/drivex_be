package com.example.drivex_be.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "monthly_driver_ranking")
public class MonthlyDriverRanking {
    @Id
    private Integer driverId;

    @Column(name = "driver_name")
    private String driverName;

    @Column(name = "total_rides")
    private Integer totalRides;

    @Column(name = "total_revenue")
    private BigDecimal totalRevenue;

    @Column(name = "avg_rating")
    private BigDecimal avgRating;
}
