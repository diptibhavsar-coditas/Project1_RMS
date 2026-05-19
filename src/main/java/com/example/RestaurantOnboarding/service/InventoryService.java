package com.example.RestaurantOnboarding.service;

import com.example.RestaurantOnboarding.dto.InventoryDto.CreateInventoryRequestDto;
import com.example.RestaurantOnboarding.dto.InventoryDto.InventoryResponseDto;
import com.example.RestaurantOnboarding.dto.InventoryDto.UpdateInventoryRequestDto;

import java.util.List;

public interface InventoryService {

//    InventoryResponseDto addIngredient(CreateInventoryRequestDto dto);
//
//    InventoryResponseDto updateIngredient(Long id, UpdateInventoryRequestDto dto);
//
//    InventoryResponseDto getIngredientById(Long id);
//
//    List<InventoryResponseDto> getAllIngredients(Long branchId);
//
      void reduceStock(Long ingredientId, int quantity);


//
     void increaseStock(Long ingredientId, int quantity);
//
//    void deleteIngredient(Long id);
//
//    List<InventoryResponseDto> getLowStockItems(Long branchId);
}