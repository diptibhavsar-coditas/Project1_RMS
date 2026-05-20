package com.example.RestaurantOnboarding.dto.OrderDto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponseDto {

    private Long orderId;
    private String status;
    private Double totalAmount;
    private Integer tableNumber;

}