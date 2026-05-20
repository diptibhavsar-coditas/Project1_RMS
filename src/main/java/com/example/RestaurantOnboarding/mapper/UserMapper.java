package com.example.RestaurantOnboarding.mapper;

import com.example.RestaurantOnboarding.dto.UserDto.UserResponseDto;
import com.example.RestaurantOnboarding.entity.User;

public interface UserMapper {

    UserResponseDto toDto(User entity);
}