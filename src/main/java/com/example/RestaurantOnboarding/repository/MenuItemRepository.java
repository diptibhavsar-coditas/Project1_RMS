package com.example.RestaurantOnboarding.repository;

import com.example.RestaurantOnboarding.entity.MenuItem;
import com.example.RestaurantOnboarding.enums.DishCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

    List<MenuItem> findByItemId(Long itemId);

    List<MenuItem> findByCategory(DishCategory category);

    //List<MenuItem> findByStatus(MenuItemStatus status);
}
