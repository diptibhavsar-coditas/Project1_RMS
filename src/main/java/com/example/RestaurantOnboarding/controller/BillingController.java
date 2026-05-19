package com.example.RestaurantOnboarding.controller;

import com.example.RestaurantOnboarding.dto.BillingDto.BillResponseDto;
import com.example.RestaurantOnboarding.exception.ApiResponse;
import com.example.RestaurantOnboarding.service.BillingService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing")
public class BillingController {

    private final BillingService billingService;

    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    @PreAuthorize("hasAnyRole('CASHIER','RESTAURANT_OWNER','SUPER_ADMIN')")
    @GetMapping("/{orderId}")
    public ResponseEntity<ApiResponse<BillResponseDto>> generateBill(
            @PathVariable Long orderId) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Bill generated",
                        billingService.generateBill(orderId))
        );
    }
}