package com.example.RestaurantOnboarding.repository;

import com.example.RestaurantOnboarding.entity.TableMaster;
import com.example.RestaurantOnboarding.enums.TableStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TableRepository extends JpaRepository<TableMaster, Long> {

    List<TableMaster> findByBranchId(Long branchId);

    List<TableMaster> findByStatus(TableStatus status);
}