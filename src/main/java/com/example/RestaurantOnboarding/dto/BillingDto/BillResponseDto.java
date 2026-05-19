package com.example.RestaurantOnboarding.dto.BillingDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillResponseDto {

    private Long billId;
    private Double subTotal;
    private Double gst;
    private Double vat;
    private Double discount;
    private Double totalAmount;
}