package com.example.RestaurantOnboarding.service.impl;

import com.example.RestaurantOnboarding.entity.InventoryStock;
import com.example.RestaurantOnboarding.exception.BusinessException;
import com.example.RestaurantOnboarding.exception.ResourceNotFoundException;
import com.example.RestaurantOnboarding.repository.InventoryRepository;
import com.example.RestaurantOnboarding.service.InventoryService;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public void reduceStock(Long ingredientId, int quantity) {

        InventoryStock inventory = inventoryRepository.findById(ingredientId)
                .orElseThrow(() -> new ResourceNotFoundException("Ingredient not found"));

        if (inventory.getAvailableQuantity() < quantity) {
            throw new BusinessException("Stock cannot go negative");
        }

        inventory.setAvailableQuantity(inventory.getAvailableQuantity() - quantity);

        inventoryRepository.save(inventory);
    }
}