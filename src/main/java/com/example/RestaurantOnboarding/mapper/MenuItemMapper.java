package com.example.RestaurantOnboarding.mapper;

import com.example.RestaurantOnboarding.dto.MenuDto.CreateMenuItemRequestDto;
import com.example.RestaurantOnboarding.dto.MenuDto.MenuItemResponseDto;
import com.example.RestaurantOnboarding.entity.MenuItem;

public interface MenuItemMapper {

    MenuItemResponseDto toDto(MenuItem entity);

    MenuItem toEntity(CreateMenuItemRequestDto dto);
}