package com.example.RestaurantOnboarding.mapper.impl;

import com.example.RestaurantOnboarding.dto.StaffDto.CreateStaffRequestDto;
import com.example.RestaurantOnboarding.dto.UserDto.UserResponseDto;
import com.example.RestaurantOnboarding.entity.User;
import com.example.RestaurantOnboarding.mapper.UserMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

    private final ModelMapper modelMapper;

    public UserMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserResponseDto toDto(User entity) {
        return modelMapper.map(entity, UserResponseDto.class);
    }

    @Override
    public User toEntity(CreateStaffRequestDto dto) {
        return modelMapper.map(dto, User.class);
    }


}