package com.example.RestaurantOnboarding.mapper.impl;

import com.example.RestaurantOnboarding.dto.BranchDto.BranchResponseDto;
import com.example.RestaurantOnboarding.dto.StaffDto.CreateStaffRequestDto;
import com.example.RestaurantOnboarding.entity.RestaurantBranch;
import com.example.RestaurantOnboarding.mapper.BranchMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BranchMapperImpl implements BranchMapper {

    private final ModelMapper modelMapper;

    public BranchMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public BranchResponseDto toDto(RestaurantBranch entity) {
        return modelMapper.map(entity, BranchResponseDto.class);
    }

    @Override
    public RestaurantBranch toEntity(CreateStaffRequestDto dto) {
        return modelMapper.map(dto, RestaurantBranch.class);
    }
}