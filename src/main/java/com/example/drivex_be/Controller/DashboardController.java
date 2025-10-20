package com.example.drivex_be.Controller;

import com.example.drivex_be.Service.DashboardService;
import com.example.drivex_be.model.MonthlyDriverRanking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/revenue")
    public List<Map<String, Object>> getDailyRevenue() {
        System.out.println("Fetching daily revenue data");
        return dashboardService.getDailyRevenue();
    }

    @GetMapping("/ride-count")
    public List<Map<String, Object>> getDailyRideCount() {
        return dashboardService.getDailyRideCount();
    }

    @GetMapping("/active-drivers")
    public Long getActiveDriversCount() {
        return dashboardService.getActiveDriversCount();
    }

    @GetMapping("/average-revenue")
    public List<Map<String, Object>> getAverageRevenueByDay() {
        return dashboardService.getAverageRevenueByDay();
    }


    @GetMapping("/monthly-driver-rankings")
    public ResponseEntity<List<MonthlyDriverRanking>> getMonthlyDriverRankings() {
        List<MonthlyDriverRanking> rankings = dashboardService.getMonthlyDriverRankings();
        return ResponseEntity.ok(rankings);
    }
}