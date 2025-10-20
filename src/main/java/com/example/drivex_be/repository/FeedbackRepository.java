package com.example.drivex_be.repository;

import com.example.drivex_be.model.Feedback;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO feedback (driverId, customerId, rideId, review, rating) " +
            "VALUES (:driverId, :customerId, :rideId, :review, :rating)", nativeQuery = true)
    void insertFeedback(
            @Param("driverId") Long driverId,
            @Param("customerId") Long customerId,
            @Param("rideId") Long rideId,
            @Param("review") String review,
            @Param("rating") Double rating
    );
}