package com.example.RestaurantOnboarding.dto.InventoryDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateInventoryRequestDto {
    private Double quantity;
    private Double costPerUnit;
    private Double reorderLevel;
}
