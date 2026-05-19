package com.example.RestaurantOnboarding.repository;

import com.example.RestaurantOnboarding.entity.BillInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepository extends JpaRepository<BillInvoice, Long> {

    List<BillInvoice> findByBranchId(Long branchId);

    List<BillInvoice> findByOrderId(Long orderId);
}
