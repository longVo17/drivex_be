package com.example.drivex_be.repository;

import com.example.drivex_be.model.Driver;
import com.example.drivex_be.model.Ride;
import com.example.drivex_be.model.Feedback;
import com.example.drivex_be.model.RidePayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    // Thông tin tài xế (bao gồm vị trí hiện tại)
    @Query(value = "SELECT d.driverId, d.name, d.phone, d.email, d.rating, " +
                   "dl.latitude, dl.longitude, dl.updated_at " +
                   "FROM drivers d " +
                   "LEFT JOIN driver_locations dl ON d.driverId = dl.driver_id " +
                   "WHERE d.driverId = ?1", nativeQuery = true)
    Driver findDriverDetailsById(Long driverId);

    // Lịch sử chuyến đi của tài xế
    @Query(value = "SELECT r.rideId, r.pickUpPosition, r.destination, r.startTime, r.endTime, r.status " +
                   "FROM rides r " +
                   "WHERE r.driverId = ?1 " +
                   "ORDER BY r.startTime DESC", nativeQuery = true)
    List<Ride> findRideHistoryByDriverId(Long driverId);

    // Đánh giá của tài xế
    @Query(value = "SELECT f.feedbackId, f.review, f.rating, f.customerId, f.rideId " +
                   "FROM feedback f " +
                   "WHERE f.driverId = ?1 " +
                   "ORDER BY f.feedbackId DESC", nativeQuery = true)
    List<Feedback> findFeedbackByDriverId(Long driverId);

    // Doanh thu của tài xế
    @Query(value = "SELECT rp.rideId, rp.paymentId, rp.payTime, rp.cost " +
                   "FROM ride_payment rp " +
                   "JOIN rides r ON r.rideId = rp.rideId " +
                   "WHERE r.driverId = ?1", nativeQuery = true)
    List<RidePayment> findRevenueByDriverId(Long driverId);
}