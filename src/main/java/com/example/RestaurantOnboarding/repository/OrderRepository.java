package com.example.RestaurantOnboarding.repository;

import com.example.RestaurantOnboarding.entity.CustomerOrder;
import com.example.RestaurantOnboarding.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<CustomerOrder, Long> {

    List<CustomerOrder> findByBranchId(Long branchId);

    List<CustomerOrder> findByStatus(OrderStatus status);

    List<CustomerOrder> findByTableId(Long tableId);
}
