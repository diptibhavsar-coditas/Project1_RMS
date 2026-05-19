package com.example.RestaurantOnboarding.controller;

import com.example.RestaurantOnboarding.dto.MenuDto.CreateMenuItemRequestDto;
import com.example.RestaurantOnboarding.dto.MenuDto.MenuItemResponseDto;
import com.example.RestaurantOnboarding.exception.ApiResponse;
import com.example.RestaurantOnboarding.service.MenuService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PreAuthorize("hasAnyRole('MANAGER','CHEF')")
    @PostMapping
    public ResponseEntity<ApiResponse<MenuItemResponseDto>> createMenuItem(
            @RequestBody @Valid CreateMenuItemRequestDto dto) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Menu item created", menuService.createMenuItem(dto))
        );
    }

    @PreAuthorize("hasAnyRole('WAITER','MANAGER','CHEF')")
    @GetMapping("/{branchId}")
    public ResponseEntity<ApiResponse<List<MenuItemResponseDto>>> getMenu(
            @PathVariable Long branchId) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Menu fetched", menuService.getMenuByBranch(branchId))
        );
    }
}