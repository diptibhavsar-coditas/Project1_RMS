package com.example.RestaurantOnboarding.controller;

import com.example.RestaurantOnboarding.dto.BranchDto.BranchResponseDto;
import com.example.RestaurantOnboarding.dto.BranchDto.CreateBranchRequestDto;
import com.example.RestaurantOnboarding.exception.ApiResponse;
import com.example.RestaurantOnboarding.service.BranchService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branches")
public class BranchController {

    private final BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @PreAuthorize("hasAnyRole('SUPER_ADMIN','RESTAURANT_OWNER')")
    @PostMapping
    public ResponseEntity<ApiResponse<BranchResponseDto>> createBranch(
            @RequestBody @Valid CreateBranchRequestDto dto) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Branch created", branchService.createBranch(dto))
        );
    }

    @PreAuthorize("hasAnyRole('SUPER_ADMIN','RESTAURANT_OWNER','MANAGER')")
    @GetMapping("/{chainId}")
    public ResponseEntity<ApiResponse<List<BranchResponseDto>>> getBranches(
            @PathVariable Long chainId) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Branches fetched", branchService.getAllBranches(chainId))
        );
    }
}