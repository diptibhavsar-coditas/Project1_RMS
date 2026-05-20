package com.example.RestaurantOnboarding.mapper;

import com.example.RestaurantOnboarding.dto.OrderDto.CreateOrderRequestDto;
import com.example.RestaurantOnboarding.dto.OrderDto.OrderResponseDto;
import com.example.RestaurantOnboarding.entity.CustomerOrder;


public interface OrderMapper {

    OrderResponseDto toDto(CustomerOrder entity);

    CustomerOrder toEntity(CreateOrderRequestDto dto);
}