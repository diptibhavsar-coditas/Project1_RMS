package com.example.RestaurantOnboarding.dto.TableDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TableResponseDto {

    private Long id;
    private Integer tableNumber;
    private Integer capacity;
    private String status;
}
