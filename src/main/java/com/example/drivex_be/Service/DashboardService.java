package com.example.drivex_be.Service;

import com.example.drivex_be.model.MonthlyDriverRanking;
import com.example.drivex_be.repository.DashboardRepository;
import com.example.drivex_be.repository.MonthlyDriverRankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DashboardService {

    @Autowired
    private DashboardRepository dashboardRepository;
    @Autowired
    private MonthlyDriverRankingRepository monthlyDriverRankingRepository;

    public List<Map<String, Object>> getDailyRevenue() {
        return dashboardRepository.getDailyRevenue();
    }

    public List<Map<String, Object>> getDailyRideCount() {
        return dashboardRepository.getDailyRideCount();
    }

    public Long getActiveDriversCount() {
        return dashboardRepository.getActiveDriversCount();
    }

    public List<Map<String, Object>> getAverageRevenueByDay() {
        return dashboardRepository.getAverageRevenueByDay();
    }

    public List<MonthlyDriverRanking> getMonthlyDriverRankings() {
        return monthlyDriverRankingRepository.getMonthlyDriverRankings();
    }
}