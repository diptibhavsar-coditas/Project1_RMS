package com.example.RestaurantOnboarding.service.impl;

import com.example.RestaurantOnboarding.dto.MenuDto.CreateMenuItemRequestDto;
import com.example.RestaurantOnboarding.dto.MenuDto.MenuItemResponseDto;
import com.example.RestaurantOnboarding.entity.MenuItem;
import com.example.RestaurantOnboarding.exception.BusinessException;
import com.example.RestaurantOnboarding.mapper.MenuItemMapper;
import com.example.RestaurantOnboarding.repository.MenuItemRepository;
import com.example.RestaurantOnboarding.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuItemRepository menuItemRepository;
    private final MenuItemMapper menuItemMapper;

    public MenuServiceImpl(MenuItemRepository menuItemRepository,
                           MenuItemMapper menuItemMapper) {
        this.menuItemRepository = menuItemRepository;
        this.menuItemMapper = menuItemMapper;
    }

    @Override
    public MenuItemResponseDto createMenuItem(CreateMenuItemRequestDto dto) {

        if (dto.getCalories() <= 0 || dto.getPrice() <= 0) {
            throw new BusinessException("Invalid menu item data");
        }

        MenuItem item = menuItemMapper.toEntity(dto);
        return menuItemMapper.toDto(menuItemRepository.save(item));
    }

    @Override
    public List<MenuItemResponseDto> getMenuByBranch(Long branchId) {
        return menuItemRepository.findByBranchId(branchId)
                .stream()
                .map(menuItemMapper::toDto)
                .toList();
    }
}
