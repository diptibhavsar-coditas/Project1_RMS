package com.example.RestaurantOnboarding.controller;

import com.example.RestaurantOnboarding.dto.UserDto.UserResponseDto;
import com.example.RestaurantOnboarding.exception.ApiResponse;
import com.example.RestaurantOnboarding.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDto>> getUser(@PathVariable Long id) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "User fetched", userService.getUserById(id))
        );
    }
}