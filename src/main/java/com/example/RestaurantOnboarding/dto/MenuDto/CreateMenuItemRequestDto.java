package com.example.RestaurantOnboarding.dto.MenuDto;

import com.example.RestaurantOnboarding.entity.DishIngredient;
import com.example.RestaurantOnboarding.enums.DishCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMenuItemRequestDto {

    @NotBlank
    private String name;

    @Size(max = 255)
    private String description;

    @NotNull
    @Positive
    private Double price;

    @NotNull
    @Positive
    private Integer calories;

    @NotNull
    private DishCategory category;

    @NotNull
    private DishIngredient dishType;

}