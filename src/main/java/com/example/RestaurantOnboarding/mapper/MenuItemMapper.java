package com.example.RestaurantOnboarding.mapper;

import com.example.RestaurantOnboarding.dto.MenuDto.CreateMenuItemRequestDto;
import com.example.RestaurantOnboarding.dto.MenuDto.MenuItemResponseDto;
import com.example.RestaurantOnboarding.entity.MenuItem;

public interface MenuItemMapper extends BaseMapper<MenuItem, MenuItemResponseDto> {
    MenuItem toEntity(CreateMenuItemRequestDto dto);
}