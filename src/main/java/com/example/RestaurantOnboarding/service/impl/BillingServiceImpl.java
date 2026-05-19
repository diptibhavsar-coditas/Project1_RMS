package com.example.RestaurantOnboarding.service.impl;

import com.example.RestaurantOnboarding.dto.BillingDto.BillResponseDto;
import com.example.RestaurantOnboarding.entity.BillInvoice;
import com.example.RestaurantOnboarding.entity.CustomerOrder;
import com.example.RestaurantOnboarding.exception.ResourceNotFoundException;
import com.example.RestaurantOnboarding.repository.BillRepository;
import com.example.RestaurantOnboarding.repository.OrderRepository;
import com.example.RestaurantOnboarding.service.BillingService;
import org.springframework.stereotype.Service;

@Service
public class BillingServiceImpl implements BillingService {

    private final OrderRepository orderRepository;
    private final BillRepository billRepository;

    public BillingServiceImpl(OrderRepository orderRepository,
                              BillRepository billRepository) {
        this.orderRepository = orderRepository;
        this.billRepository = billRepository;
    }

    @Override
    public BillResponseDto generateBill(Long orderId) {

        CustomerOrder order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        Double subtotal = order.getBillInvoice().getFinalAmount();

        double gst = subtotal * 0.05;
        double vat = 0;

        double total = subtotal + gst + vat;

        BillInvoice bill = new BillInvoice();
        bill.setOrder(order);
        bill.setTotalAmount(total);

        billRepository.save(bill);

        BillResponseDto dto = new BillResponseDto();
        dto.setBillId(bill.getInvoiceId());
        dto.setSubTotal(subtotal);
        dto.setGst(gst);
        dto.setVat(vat);
        dto.setTotalAmount(total);

        return dto;
    }
}