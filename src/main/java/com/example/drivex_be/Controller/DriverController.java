package com.example.drivex_be.Controller;

import com.example.drivex_be.Service.DriverService;
import com.example.drivex_be.model.Driver;
import com.example.drivex_be.model.Ride;
import com.example.drivex_be.model.Feedback;
import com.example.drivex_be.model.RidePayment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping("/details/{driverId}")
    public Driver getDriverDetails(@PathVariable Long driverId) {
        return driverService.getDriverDetails(driverId);
    }

    @GetMapping("/history/{driverId}")
    public List<Ride> getRideHistory(@PathVariable Long driverId) {
        return driverService.getRideHistory(driverId);
    }

    @GetMapping("/feedback/{driverId}")
    public List<Feedback> getFeedback(@PathVariable Long driverId) {
        return driverService.getFeedback(driverId);
    }

    @GetMapping("/revenue/{driverId}")
    public List<RidePayment> getRevenue(@PathVariable Long driverId) {
        return driverService.getRevenue(driverId);
    }
}