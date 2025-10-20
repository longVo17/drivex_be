package com.example.drivex_be.Service;

import com.example.drivex_be.model.Customer;
import com.example.drivex_be.model.Ride;
import com.example.drivex_be.model.Promotion;
import com.example.drivex_be.model.RideRequest;
import com.example.drivex_be.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Ride> getRideHistory(Long customerId) {
        return userRepository.findRideHistoryByCustomerId(customerId);
    }

    public List<Promotion> getActivePromotions(Long customerId) {
        return userRepository.findActivePromotionsByCustomerId(customerId);
    }

    public List<RideRequest> getRideRequestStatus(Long customerId) {
        return userRepository.findRideRequestStatusByCustomerId(customerId);
    }

    public Customer getUserDetails(Long customerId) {
        return userRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerId));
    }
}