package com.example.RestaurantOnboarding.mapper.impl;

import com.example.RestaurantOnboarding.dto.BranchDto.BranchResponseDto;
import com.example.RestaurantOnboarding.dto.BranchDto.CreateBranchRequestDto;
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

        BranchResponseDto dto =
                modelMapper.map(entity, BranchResponseDto.class);

        if (entity.getRestaurantChain() != null) {
            dto.setChainName(entity.getRestaurantChain().getChainName());
        }

        if (entity.getGstType() != null) {
            dto.setGstType(entity.getGstType().name());
        }

        return dto;
    }

    @Override
    public RestaurantBranch toEntity(CreateBranchRequestDto dto) {

        return modelMapper.map(dto, RestaurantBranch.class);
    }
}