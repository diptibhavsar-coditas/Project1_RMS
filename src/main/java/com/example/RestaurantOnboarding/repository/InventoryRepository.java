package com.example.RestaurantOnboarding.repository;

import com.example.RestaurantOnboarding.entity.InventoryStock;
import com.example.RestaurantOnboarding.enums.StockStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<InventoryStock, Long> {

    List<InventoryStock> findByBranchId(Long branchId);

    List<InventoryStock> findByStockStatus(StockStatus stockStatus);
}