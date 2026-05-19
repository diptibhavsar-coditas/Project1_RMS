package com.example.RestaurantOnboarding.dto.OrderDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponseDto {

    private Long orderId;
    private String status;
    private Double totalAmount;
}