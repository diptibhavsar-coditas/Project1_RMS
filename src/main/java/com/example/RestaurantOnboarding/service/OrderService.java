package com.example.RestaurantOnboarding.service;

import com.example.RestaurantOnboarding.dto.OrderDto.CreateOrderRequestDto;
import com.example.RestaurantOnboarding.dto.OrderDto.OrderResponseDto;
import com.example.RestaurantOnboarding.enums.OrderStatus;

public interface OrderService {
    OrderResponseDto createOrder(CreateOrderRequestDto dto);
    OrderResponseDto updateStatus(Long orderId, OrderStatus status);
}