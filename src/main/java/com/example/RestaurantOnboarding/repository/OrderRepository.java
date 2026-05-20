package com.example.RestaurantOnboarding.repository;

import com.example.RestaurantOnboarding.entity.CustomerOrder;
import com.example.RestaurantOnboarding.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<CustomerOrder, Long> {
    List<CustomerOrder> findByStatus(OrderStatus status);
    List<CustomerOrder> findByBranch_BranchId(Long branchId);
}