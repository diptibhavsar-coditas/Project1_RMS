package com.example.RestaurantOnboarding.dto.AuthDto;

import com.example.RestaurantOnboarding.enums.RoleType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResponseDto {

    private String token;

    private String tokenType;

    private String role;

    private Long userId;

    private String email;

    private String message;


}