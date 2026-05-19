package com.example.RestaurantOnboarding.dto.AuthDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponseDto {

    private String token;
    private String tokenType;
    private String role;
    private Long userId;
    private String email;
    private String message;
}