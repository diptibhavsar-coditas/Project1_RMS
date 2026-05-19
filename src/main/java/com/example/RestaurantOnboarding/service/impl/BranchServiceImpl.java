package com.example.RestaurantOnboarding.service.impl;

import com.example.RestaurantOnboarding.dto.BranchDto.BranchResponseDto;
import com.example.RestaurantOnboarding.dto.BranchDto.CreateBranchRequestDto;
import com.example.RestaurantOnboarding.entity.RestaurantBranch;
import com.example.RestaurantOnboarding.exception.BusinessException;
import com.example.RestaurantOnboarding.mapper.BranchMapper;
import com.example.RestaurantOnboarding.repository.BranchRepository;
import com.example.RestaurantOnboarding.service.BranchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    private final BranchMapper branchMapper;

    public BranchServiceImpl(BranchRepository branchRepository,
                             BranchMapper branchMapper) {
        this.branchRepository = branchRepository;
        this.branchMapper = branchMapper;
    }

    @Override
    public BranchResponseDto createBranch(CreateBranchRequestDto dto) {

        if (branchRepository.existsByNameAndChainId(dto.getName(), dto.getChainId())) {
            throw new BusinessException("Branch already exists in chain");
        }

        RestaurantBranch branch = branchMapper.toEntity(dto);
        return branchMapper.toDto(branchRepository.save(branch));
    }

    @Override
    public List<BranchResponseDto> getAllBranches(Long chainId) {
        return branchRepository.findByChainId(chainId)
                .stream()
                .map(branchMapper::toDto)
                .toList();
    }
}
