package com.example.RestaurantOnboarding.mapper;

import com.example.RestaurantOnboarding.dto.BranchDto.BranchResponseDto;
import com.example.RestaurantOnboarding.dto.BranchDto.CreateBranchRequestDto;
import com.example.RestaurantOnboarding.entity.RestaurantBranch;

public interface BranchMapper {

    BranchResponseDto toDto(RestaurantBranch entity);


    RestaurantBranch toEntity(CreateBranchRequestDto dto);
}