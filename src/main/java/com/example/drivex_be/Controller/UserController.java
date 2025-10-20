package com.example.drivex_be.Controller;

import com.example.drivex_be.Service.UserService;
import com.example.drivex_be.model.Customer;
import com.example.drivex_be.model.Ride;
import com.example.drivex_be.model.Promotion;
import com.example.drivex_be.model.RideRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/details/{customerId}")
    public Customer getUserDetails(@PathVariable Long customerId) {
        return userService.getUserDetails(customerId);
    }

    @GetMapping("/history/{customerId}")
    public List<Ride> getRideHistory(@PathVariable Long customerId) {
        return userService.getRideHistory(customerId);
    }

    @GetMapping("/promotions/{customerId}")
    public List<Promotion> getActivePromotions(@PathVariable Long customerId) {
        return userService.getActivePromotions(customerId);
    }

    @GetMapping("/requests/{customerId}")
    public List<RideRequest> getRideRequestStatus(@PathVariable Long customerId) {
        return userService.getRideRequestStatus(customerId);
    }
}