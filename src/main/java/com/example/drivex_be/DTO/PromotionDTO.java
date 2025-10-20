package com.example.drivex_be.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PromotionDTO {
    private Long promotionId;
    private Long customerId;
    private LocalDate start_date;
    private LocalDate end_date;
    private Double amount;
    private Double discount_percent;
    private String description;

    public PromotionDTO(Long promotionId, Long customerId, LocalDate start_date, LocalDate end_date, Double amount, Double discount_percent, String description) {
        this.promotionId = promotionId;
        this.customerId = customerId;
        this.start_date = start_date;
        this.end_date = end_date;
        this.amount = amount;
        this.discount_percent = discount_percent;
        this.description = description;
    }
}