package com.example.RestaurantOnboarding.repository;

import com.example.RestaurantOnboarding.entity.RestaurantBranch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BranchRepository extends JpaRepository<RestaurantBranch, Long> {

    List<RestaurantBranch> findByBranchId(Long branchId);

    boolean existsByNameAndBranchId(String name, Long branchId);
}