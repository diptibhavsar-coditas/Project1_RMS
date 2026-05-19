package com.example.RestaurantOnboarding.dto.OrderDto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDto {

    @NotNull
    private Long menuItemId;

    @NotNull
    @Min(1)
    private Integer quantity;
}