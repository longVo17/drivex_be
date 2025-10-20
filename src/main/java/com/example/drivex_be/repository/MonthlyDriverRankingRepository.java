package com.example.drivex_be.repository;

import com.example.drivex_be.model.MonthlyDriverRanking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonthlyDriverRankingRepository extends JpaRepository<MonthlyDriverRanking, Integer> {
    @Query(value = "SELECT * FROM monthly_driver_ranking", nativeQuery = true)
    List<MonthlyDriverRanking> getMonthlyDriverRankings();
}