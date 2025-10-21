package com.example.drivex_be.repository;

import com.example.drivex_be.model.RidePayment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface RidePaymentRepository extends JpaRepository<RidePayment, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ride_payment (rideId, payTime, cost) VALUES (:rideId, :payTime, :cost)", nativeQuery = true)
    void payRide(Integer rideId, LocalDateTime payTime, Double cost);
}
