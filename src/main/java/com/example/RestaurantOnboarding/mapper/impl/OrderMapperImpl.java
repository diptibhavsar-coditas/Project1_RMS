package com.example.RestaurantOnboarding.mapper.impl;

import com.example.RestaurantOnboarding.dto.OrderDto.OrderResponseDto;
import com.example.RestaurantOnboarding.dto.StaffDto.CreateStaffRequestDto;
import com.example.RestaurantOnboarding.entity.CustomerOrder;
import com.example.RestaurantOnboarding.mapper.OrderMapper;
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
        return modelMapper.map(entity, OrderResponseDto.class);
    }

    @Override
    public CustomerOrder toEntity(CreateStaffRequestDto dto) {
        return modelMapper.map(dto, CustomerOrder.class);
    }
}
