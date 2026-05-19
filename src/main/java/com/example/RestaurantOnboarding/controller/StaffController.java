package com.example.RestaurantOnboarding.controller;

import com.example.RestaurantOnboarding.dto.StaffDto.CreateStaffRequestDto;
import com.example.RestaurantOnboarding.dto.StaffDto.StaffResponseDto;
import com.example.RestaurantOnboarding.exception.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @PreAuthorize("hasAnyRole('SUPER_ADMIN','RESTAURANT_OWNER')")
    @PostMapping
    public ResponseEntity<ApiResponse<StaffResponseDto>> createStaff(
            @RequestBody @Valid CreateStaffRequestDto dto) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Staff created", staffService.createStaff(dto))
        );
    }
}
