package com.example.RestaurantOnboarding.service;

import com.example.RestaurantOnboarding.dto.StaffDto.CreateStaffRequestDto;
import com.example.RestaurantOnboarding.dto.StaffDto.StaffResponseDto;
import com.example.RestaurantOnboarding.dto.StaffDto.UpdateStaffRequestDto;
import com.example.RestaurantOnboarding.entity.RestaurantBranch;
import com.example.RestaurantOnboarding.entity.Staff;
import com.example.RestaurantOnboarding.exception.BusinessException;
import com.example.RestaurantOnboarding.exception.ResourceNotFoundException;
import com.example.RestaurantOnboarding.mapper.StaffMapper;
import com.example.RestaurantOnboarding.repository.BranchRepository;
import com.example.RestaurantOnboarding.repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface StaffService {

        StaffResponseDto createStaff(CreateStaffRequestDto dto);

}