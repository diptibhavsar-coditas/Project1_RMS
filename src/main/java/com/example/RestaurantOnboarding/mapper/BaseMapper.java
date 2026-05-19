package com.example.RestaurantOnboarding.mapper;

import com.example.RestaurantOnboarding.dto.BranchDto.CreateBranchRequestDto;
import com.example.RestaurantOnboarding.dto.StaffDto.CreateStaffRequestDto;
import com.example.RestaurantOnboarding.entity.RestaurantBranch;

public interface BaseMapper<E, D> {

    D toDto(E entity);

    E toEntity(CreateStaffRequestDto dto);

    RestaurantBranch toEntity(CreateBranchRequestDto dto);
}
