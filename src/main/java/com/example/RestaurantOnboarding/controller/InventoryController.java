package com.example.RestaurantOnboarding.controller;

import com.example.RestaurantOnboarding.exception.ApiResponse;
import com.example.RestaurantOnboarding.service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PreAuthorize("hasAnyRole('MANAGER','CHEF')")
    @PostMapping("/reduce")
    public ResponseEntity<ApiResponse<String>> reduceStock(
            @RequestParam Long ingredientId,
            @RequestParam int quantity) {

        inventoryService.reduceStock(ingredientId, quantity);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Stock reduced", "SUCCESS")
        );
    }

    @PreAuthorize("hasAnyRole('MANAGER','SUPER_ADMIN')")
    @PostMapping("/increase")
    public ResponseEntity<ApiResponse<String>> increaseStock(
            @RequestParam Long ingredientId,
            @RequestParam int quantity) {

        inventoryService.increaseStock(ingredientId, quantity);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Stock increased", "SUCCESS")
        );
    }
}