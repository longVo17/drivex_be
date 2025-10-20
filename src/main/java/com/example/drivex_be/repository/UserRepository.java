package com.example.drivex_be.repository;

import com.example.drivex_be.model.Customer;
import com.example.drivex_be.model.Ride;
import com.example.drivex_be.model.Promotion;
import com.example.drivex_be.model.RideRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

    @Repository
    public interface UserRepository extends JpaRepository<Customer, Long> {

        // Lịch sử đặt xe (rides) của khách hàng
        @Query(value = "SELECT r.rideId, r.pickUpPosition, r.destination, r.startTime, r.endTime, r.status " +
                       "FROM rides r " +
                       "WHERE r.customerId = ?1 " +
                       "ORDER BY r.startTime DESC", nativeQuery = true)
        List<Ride> findRideHistoryByCustomerId(Long customerId);

        // Danh sách khuyến mãi của khách hàng
        @Query(value = "SELECT p.promotionId, p.start_date, p.end_date, p.amount, p.discount_percent, p.description " +
                       "FROM promotion p " +
                       "WHERE p.customerId = ?1 " +
                       "AND (p.end_date IS NULL OR p.end_date >= CURRENT_DATE)", nativeQuery = true)
        List<Promotion> findActivePromotionsByCustomerId(Long customerId);

        // Trạng thái yêu cầu đặt xe của khách hàng
        @Query(value = "SELECT rr.id, rr.pickup_location, rr.dropoff_location, rr.request_time, rr.status " +
                       "FROM ride_requests rr " +
                       "WHERE rr.customerId = ?1 " +
                       "ORDER BY rr.request_time DESC", nativeQuery = true)
        List<RideRequest> findRideRequestStatusByCustomerId(Long customerId);
    }