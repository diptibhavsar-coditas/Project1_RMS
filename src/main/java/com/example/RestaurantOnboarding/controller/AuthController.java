package com.example.RestaurantOnboarding.controller;

import com.example.RestaurantOnboarding.dto.AuthDto.AuthResponseDto;
import com.example.RestaurantOnboarding.dto.AuthDto.LoginRequestDto;
import com.example.RestaurantOnboarding.exception.ApiResponse;
import com.example.RestaurantOnboarding.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponseDto>> login(
            @RequestBody @Valid LoginRequestDto request) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Login successful", userService.login(request))
        );
    }
}
