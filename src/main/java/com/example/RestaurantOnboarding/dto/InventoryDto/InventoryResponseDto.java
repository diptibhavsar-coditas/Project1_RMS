package com.example.RestaurantOnboarding.dto.InventoryDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryResponseDto {
    private Long id;
    private String ingredientName;
    private Double quantity;
    private String unit;
    private String stockStatus;
}
