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
public class StaffServiceImpl  {

    private final StaffRepository staffRepository;
    private final BranchRepository branchRepository;
    private final StaffMapper staffMapper;

    public StaffServiceImpl(StaffRepository staffRepository,
                            BranchRepository branchRepository,
                            StaffMapper staffMapper) {
        this.staffRepository = staffRepository;
        this.branchRepository = branchRepository;
        this.staffMapper = staffMapper;
    }

    public StaffResponseDto createStaff(CreateStaffRequestDto dto) {

        if (dto.getSalary() <= 0) {
            throw new BusinessException("Salary must be greater than 0");
        }

        RestaurantBranch branch = branchRepository.findById(dto.getBranchId())
                .orElseThrow(() -> new ResourceNotFoundException("Branch not found"));

        Staff staff = staffMapper.toEntity(dto);
        staff.setBranch(branch);

        Staff saved = staffRepository.save(staff);

        return staffMapper.toDto(saved);
    }

    public StaffResponseDto getStaffById(Long id) {

        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Staff not found"));

        return staffMapper.toDto(staff);
    }


    public List<StaffResponseDto> getAllStaffByBranch(Long branchId) {

        List<Staff> staffList = staffRepository.findByBranchId(branchId);

        return staffList.stream()
                .map(staffMapper::toDto)
                .toList();
    }


    public StaffResponseDto updateStaff(Long id, UpdateStaffRequestDto dto) {

        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Staff not found"));

        if (dto.getSalary() != null && dto.getSalary() <= 0) {
            throw new BusinessException("Salary must be positive");
        }

        if (dto.getName() != null) {
            staff.setFullName(dto.getName());
        }

        if (dto.getPhone() != null) {
            staff.setPhone(dto.getPhone());
        }

        if (dto.getSalary() != null) {
            staff.setSalary(BigDecimal.valueOf(dto.getSalary()));
        }

        if (dto.getStaffRole() != null) {
            staff.setStaffRole(dto.getStaffRole());
        }

        return staffMapper.toDto(staffRepository.save(staff));
    }
    
    public void deleteStaff(Long id) {

        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Staff not found"));

        staffRepository.delete(staff);
    }
}