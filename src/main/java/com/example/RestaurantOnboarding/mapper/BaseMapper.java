package com.example.RestaurantOnboarding.mapper;

import com.example.RestaurantOnboarding.dto.StaffDto.CreateStaffRequestDto;

public interface BaseMapper<E, D> {

    D toDto(E entity);

    E toEntity(CreateStaffRequestDto dto);
}
