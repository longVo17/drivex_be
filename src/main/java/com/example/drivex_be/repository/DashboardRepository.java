package com.example.drivex_be.repository;

import com.example.drivex_be.model.RidePayment;


import com.example.drivex_be.model.RidePaymentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DashboardRepository extends JpaRepository<RidePayment, RidePaymentId> { // Thêm extends JpaRepository
    // Biểu đồ doanh thu (tổng doanh thu từng ngày)
    @Query(value = "SELECT rp.payTime::date AS payment_date, SUM(rp.cost) AS daily_revenue " +
            "FROM ride_payment rp " +
            "GROUP BY rp.payTime::date " +
            "ORDER BY rp.payTime::date", nativeQuery = true)
    List<Map<String, Object>> getDailyRevenue();

    // Số chuyến đi (tổng số ride theo ngày)
    @Query(value = "SELECT r.startTime::date AS ride_date, COUNT(r.rideId) AS ride_count " +
            "FROM rides r " +
            "GROUP BY r.startTime::date " +
            "ORDER BY r.startTime::date", nativeQuery = true)
    List<Map<String, Object>> getDailyRideCount();

    // Số tài xế hoạt động (có vị trí cập nhật trong 24 giờ)
    @Query(value = "SELECT COUNT(DISTINCT dl.driver_id) AS active_drivers " +
            "FROM driver_locations dl " +
            "WHERE dl.updated_at >= CURRENT_TIMESTAMP - INTERVAL '24 hours'", nativeQuery = true)
    Long getActiveDriversCount();


    // Doanh thu trung bình theo ngày (bao gồm cộng dồn)
    @Query(value = "SELECT rp.payTime::date AS payment_date, " +
            "SUM(rp.cost) AS daily_revenue, " +
            "SUM(SUM(rp.cost)) OVER (ORDER BY rp.payTime::date) AS cumulative_revenue, " +
            "ROUND(AVG(SUM(rp.cost)) OVER (ORDER BY rp.payTime::date), 2) AS running_avg_revenue " +
            "FROM ride_payment rp " +
            "GROUP BY rp.payTime::date " +
            "ORDER BY rp.payTime::date", nativeQuery = true)
    List<Map<String, Object>> getAverageRevenueByDay();
}