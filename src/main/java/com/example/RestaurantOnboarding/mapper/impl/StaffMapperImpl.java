package com.example.RestaurantOnboarding.mapper.impl;

import com.example.RestaurantOnboarding.dto.BranchDto.CreateBranchRequestDto;
import com.example.RestaurantOnboarding.dto.StaffDto.CreateStaffRequestDto;
import com.example.RestaurantOnboarding.dto.StaffDto.StaffResponseDto;
import com.example.RestaurantOnboarding.entity.RestaurantBranch;
import com.example.RestaurantOnboarding.entity.Staff;
import com.example.RestaurantOnboarding.mapper.StaffMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class StaffMapperImpl implements StaffMapper {

    private final ModelMapper modelMapper;

    public StaffMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public StaffResponseDto toDto(Staff entity) {

        StaffResponseDto dto =
                modelMapper.map(entity, StaffResponseDto.class);

        if (entity.getBranch() != null) {
            dto.setBranchName(entity.getBranch().getBranchName());
        }

        if (entity.getRole() != null) {
            dto.setStaffRole(entity.getRole().name());
        }

        return dto;
    }

    @Override
    public Staff toEntity(CreateStaffRequestDto dto) {

        return modelMapper.map(dto, Staff.class);
    }
}