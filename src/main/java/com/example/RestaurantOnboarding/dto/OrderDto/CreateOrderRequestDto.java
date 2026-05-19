package com.example.RestaurantOnboarding.dto.OrderDto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateOrderRequestDto {

    @NotNull
    private Long tableId;

    @NotEmpty(message = "Order must contain at least one item")
    private List<OrderItemDto> items;
}
