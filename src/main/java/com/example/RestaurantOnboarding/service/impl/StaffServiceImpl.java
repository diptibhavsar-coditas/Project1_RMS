package com.example.RestaurantOnboarding.service.impl;

import com.example.RestaurantOnboarding.dto.StaffDto.CreateStaffRequestDto;
import com.example.RestaurantOnboarding.dto.StaffDto.StaffResponseDto;
import com.example.RestaurantOnboarding.entity.Staff;
import com.example.RestaurantOnboarding.exception.BusinessException;
import com.example.RestaurantOnboarding.mapper.StaffMapper;
import com.example.RestaurantOnboarding.repository.StaffRepository;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl {

    private final StaffRepository staffRepository;
    private final StaffMapper staffMapper;

    public StaffServiceImpl(StaffRepository staffRepository,
                            StaffMapper staffMapper) {
        this.staffRepository = staffRepository;
        this.staffMapper = staffMapper;
    }


    public StaffResponseDto createStaff(CreateStaffRequestDto dto) {

        if (dto.getSalary() <= 0) {
            throw new BusinessException("Salary must be positive");
        }

        Staff staff = staffMapper.toEntity(dto);
        return staffMapper.toDto(staffRepository.save(staff));
    }
}