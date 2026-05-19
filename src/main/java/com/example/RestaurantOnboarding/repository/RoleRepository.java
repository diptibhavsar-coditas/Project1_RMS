package com.example.RestaurantOnboarding.repository;

import com.example.RestaurantOnboarding.entity.Role;
import com.example.RestaurantOnboarding.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleName(RoleType roleName);
}