package com.example.RestaurantOnboarding.service;

import com.example.RestaurantOnboarding.dto.MenuDto.CreateMenuItemRequestDto;
import com.example.RestaurantOnboarding.dto.MenuDto.MenuItemResponseDto;

import java.util.List;

public interface MenuService {
    MenuItemResponseDto createMenuItem(CreateMenuItemRequestDto dto);
    List<MenuItemResponseDto> getMenuByBranch(Long branchId);
}