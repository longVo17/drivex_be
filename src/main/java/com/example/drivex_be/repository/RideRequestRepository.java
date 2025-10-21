package com.example.drivex_be.repository;

import com.example.drivex_be.model.RideRequest;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRequestRepository extends JpaRepository<RideRequest, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE RideRequest r SET r.status = 'accepted' WHERE r.id = :requestId")
    void acceptRideRequest(Integer requestId);
}