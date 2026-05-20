package com.example.RestaurantOnboarding.mapper.impl;

import com.example.RestaurantOnboarding.dto.BranchDto.CreateBranchRequestDto;
import com.example.RestaurantOnboarding.dto.MenuDto.CreateMenuItemRequestDto;
import com.example.RestaurantOnboarding.dto.MenuDto.MenuItemResponseDto;
import com.example.RestaurantOnboarding.dto.StaffDto.CreateStaffRequestDto;
import com.example.RestaurantOnboarding.entity.MenuItem;
import com.example.RestaurantOnboarding.entity.RestaurantBranch;
import com.example.RestaurantOnboarding.mapper.MenuItemMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MenuItemMapperImpl implements MenuItemMapper {

    private final ModelMapper modelMapper;

    public MenuItemMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public MenuItemResponseDto toDto(MenuItem entity) {

        MenuItemResponseDto dto =
                modelMapper.map(entity, MenuItemResponseDto.class);

        if (entity.getCategory() != null) {
            dto.setCategory(entity.getCategory().name());
        }

        return dto;
    }

    @Override
    public MenuItem toEntity(CreateMenuItemRequestDto dto) {

        return modelMapper.map(dto, MenuItem.class);
    }
}