package com.example.RestaurantOnboarding.repository;

import com.example.RestaurantOnboarding.entity.RestaurantChain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantChainRepository extends JpaRepository<RestaurantChain, Long> {

    List<RestaurantChain> findByOwnerId(Long ownerId);
}