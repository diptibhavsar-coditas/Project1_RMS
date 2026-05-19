package com.example.RestaurantOnboarding.dto.MenuDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuItemResponseDto {

    private Long id;
    private String name;
    private Double price;
    private String category;
    private String status;
}