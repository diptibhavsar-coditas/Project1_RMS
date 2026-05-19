package com.example.RestaurantOnboarding.controller;

import com.example.RestaurantOnboarding.dto.OrderDto.CreateOrderRequestDto;
import com.example.RestaurantOnboarding.dto.OrderDto.OrderResponseDto;
import com.example.RestaurantOnboarding.enums.OrderStatus;
import com.example.RestaurantOnboarding.exception.ApiResponse;
import com.example.RestaurantOnboarding.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PreAuthorize("hasRole('WAITER')")
    @PostMapping
    public ResponseEntity<ApiResponse<OrderResponseDto>> createOrder(
            @RequestBody @Valid CreateOrderRequestDto dto) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Order created", orderService.createOrder(dto))
        );
    }

    @PreAuthorize("hasAnyRole('CHEF','MANAGER')")
    @PutMapping("/{orderId}/status")
    public ResponseEntity<ApiResponse<OrderResponseDto>> updateStatus(
            @PathVariable Long orderId,
            @RequestParam OrderStatus status) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Order updated",
                        orderService.updateStatus(orderId, status))
        );
    }
}