package com.example.RestaurantOnboarding.dto.InventoryDto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateInventoryRequestDto {
    private Long branchId;
    private String ingredientName;
    private Double quantity;
    private String unit;
    private Double costPerUnit;
    private Double reorderLevel;
}
