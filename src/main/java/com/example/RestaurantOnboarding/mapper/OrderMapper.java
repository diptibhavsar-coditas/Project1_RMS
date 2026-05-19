package com.example.RestaurantOnboarding.mapper;

import com.example.RestaurantOnboarding.dto.OrderDto.OrderResponseDto;
import com.example.RestaurantOnboarding.entity.CustomerOrder;
import jakarta.persistence.criteria.Order;

public interface OrderMapper extends BaseMapper<CustomerOrder, OrderResponseDto> {
}