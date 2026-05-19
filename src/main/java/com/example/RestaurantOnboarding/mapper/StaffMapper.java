package com.example.RestaurantOnboarding.mapper;

import com.example.RestaurantOnboarding.dto.StaffDto.CreateStaffRequestDto;
import com.example.RestaurantOnboarding.dto.StaffDto.StaffResponseDto;
import com.example.RestaurantOnboarding.entity.Staff;

public interface StaffMapper extends BaseMapper<Staff, StaffResponseDto> {

    @Override
    StaffResponseDto toDto(Staff entity);

    @Override
    Staff toEntity(CreateStaffRequestDto dto);

    Staff toEntity(StaffResponseDto dto);
}
