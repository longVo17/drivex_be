package com.example.drivex_be.DTO;

import lombok.Data;

@Data
public class FeedbackDTO {
    private Long feedbackId;
    private Long driverId;
    private Long customerId;
    private Long rideId;
    private String review;
    private Integer rating;

    public FeedbackDTO(Long feedbackId, Long driverId, Long customerId, Long rideId, String review, Integer rating) {
        this.feedbackId = feedbackId;
        this.driverId = driverId;
        this.customerId = customerId;
        this.rideId = rideId;
        this.review = review;
        this.rating = rating;
    }
}