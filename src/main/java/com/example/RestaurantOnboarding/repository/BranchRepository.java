package com.example.RestaurantOnboarding.repository;

import com.example.RestaurantOnboarding.entity.RestaurantBranch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BranchRepository extends JpaRepository<RestaurantBranch, Long> {

    List<RestaurantBranch> findByChainId(Long chainId);

    boolean existsByNameAndChainId(String name, Long chainId);
}