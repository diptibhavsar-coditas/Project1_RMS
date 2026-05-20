package com.example.RestaurantOnboarding.mapper;

import com.example.RestaurantOnboarding.dto.StaffDto.CreateStaffRequestDto;
import com.example.RestaurantOnboarding.dto.StaffDto.StaffResponseDto;
import com.example.RestaurantOnboarding.entity.Staff;

public interface StaffMapper {

    StaffResponseDto toDto(Staff entity);

    Staff toEntity(CreateStaffRequestDto dto);
}