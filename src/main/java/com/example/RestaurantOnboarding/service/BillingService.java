package com.example.RestaurantOnboarding.service;

import com.example.RestaurantOnboarding.dto.BillingDto.BillResponseDto;

public interface BillingService {
    BillResponseDto generateBill(Long orderId);
}