package com.example.RestaurantOnboarding.repository;

import com.example.RestaurantOnboarding.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff, Long> {

    List<Staff> findByBranchId(Long branchId);

    Optional<Staff> findByEmail(String email);
}
