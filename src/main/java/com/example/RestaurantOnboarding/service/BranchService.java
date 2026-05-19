package com.example.RestaurantOnboarding.service;

import com.example.RestaurantOnboarding.dto.BranchDto.BranchResponseDto;
import com.example.RestaurantOnboarding.dto.BranchDto.CreateBranchRequestDto;

import java.util.List;

public interface BranchService {
    BranchResponseDto createBranch(CreateBranchRequestDto dto);
    List<BranchResponseDto> getAllBranches(Long chainId);
}