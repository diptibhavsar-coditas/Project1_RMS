package com.example.RestaurantOnboarding.service;

import com.example.RestaurantOnboarding.dto.AuthDto.AuthResponseDto;
import com.example.RestaurantOnboarding.dto.AuthDto.LoginRequestDto;
import com.example.RestaurantOnboarding.dto.UserDto.UserResponseDto;

public interface UserService {
    AuthResponseDto login(LoginRequestDto request);
    UserResponseDto getUserById(Long id);
}