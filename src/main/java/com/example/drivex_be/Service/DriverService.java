package com.example.drivex_be.Service;

import com.example.drivex_be.model.Driver;
import com.example.drivex_be.model.Ride;
import com.example.drivex_be.model.Feedback;
import com.example.drivex_be.model.RidePayment;
import com.example.drivex_be.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public Driver getDriverDetails(Long driverId) {
        return driverRepository.findDriverDetailsById(driverId);
    }

    public List<Ride> getRideHistory(Long driverId) {
        return driverRepository.findRideHistoryByDriverId(driverId);
    }

    public List<Feedback> getFeedback(Long driverId) {
        return driverRepository.findFeedbackByDriverId(driverId);
    }

    public List<RidePayment> getRevenue(Long driverId) {
        return driverRepository.findRevenueByDriverId(driverId);
    }
}