package com.example.RestaurantOnboarding.repository;

import com.example.RestaurantOnboarding.entity.BillInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BillRepository extends JpaRepository<BillInvoice, Long> {
    Optional<BillInvoice> findByOrder_OrderId(Long orderId);

    List<BillInvoice> findByBranch_BranchId(Long branchId);

}
