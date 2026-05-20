package com.example.RestaurantOnboarding.mapper.impl;

import com.example.RestaurantOnboarding.dto.OrderDto.CreateOrderRequestDto;
import com.example.RestaurantOnboarding.dto.OrderDto.OrderResponseDto;
import com.example.RestaurantOnboarding.entity.CustomerOrder;
import com.example.RestaurantOnboarding.mapper.OrderMapper;
import jakarta.persistence.criteria.Order;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderMapperImpl implements OrderMapper {

    private final ModelMapper modelMapper;

    public OrderMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public OrderResponseDto toDto(CustomerOrder entity) {

        OrderResponseDto dto =
                modelMapper.map(entity, OrderResponseDto.class);

        if (entity.getOrderStatus() != null) {
            dto.setStatus(entity.getOrderStatus().name());
        }

        if (entity.getTable() != null) {
            dto.setTableNumber(entity.getTable().getTableNumber());
        }

        return dto;
    }

    @Override
    public CustomerOrder toEntity(CreateOrderRequestDto dto) {

        return modelMapper.map(dto, CustomerOrder.class);
    }
}