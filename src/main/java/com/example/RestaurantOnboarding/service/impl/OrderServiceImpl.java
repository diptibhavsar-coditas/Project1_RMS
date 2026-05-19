package com.example.RestaurantOnboarding.service.impl;

import com.example.RestaurantOnboarding.dto.OrderDto.CreateOrderRequestDto;
import com.example.RestaurantOnboarding.dto.OrderDto.OrderItemDto;
import com.example.RestaurantOnboarding.dto.OrderDto.OrderResponseDto;
import com.example.RestaurantOnboarding.entity.CustomerOrder;
import com.example.RestaurantOnboarding.entity.MenuItem;
import com.example.RestaurantOnboarding.enums.OrderStatus;
import com.example.RestaurantOnboarding.exception.ResourceNotFoundException;
import com.example.RestaurantOnboarding.repository.MenuItemRepository;
import com.example.RestaurantOnboarding.repository.OrderRepository;
import com.example.RestaurantOnboarding.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final MenuItemRepository menuItemRepository;

    public OrderServiceImpl(OrderRepository orderRepository,
                            MenuItemRepository menuItemRepository) {
        this.orderRepository = orderRepository;
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public OrderResponseDto createOrder(CreateOrderRequestDto dto) {

        CustomerOrder order = new CustomerOrder();
        order.setStatus(OrderStatus.PENDING);

        double total = 0;

        for (OrderItemDto itemDto : dto.getItems()) {

            MenuItem item = menuItemRepository.findById(itemDto.getMenuItemId())
                    .orElseThrow(() -> new ResourceNotFoundException("Item not found"));

            total += item.getPrice() * itemDto.getQuantity();
        }

        order.setTotalAmount(total);

        Order saved = orderRepository.save(order);

        OrderResponseDto response = new OrderResponseDto();
        response.setOrderId(saved.getId());
        response.setStatus(saved.getStatus().name());
        response.setTotalAmount(total);

        return response;
    }

    @Override
    public OrderResponseDto updateStatus(Long orderId, OrderStatus status) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        order.setStatus(status);

        orderRepository.save(order);

        OrderResponseDto response = new OrderResponseDto();
        response.setOrderId(order.getId());
        response.setStatus(status.name());
        response.setTotalAmount(order.getTotalAmount());

        return response;
    }
}
