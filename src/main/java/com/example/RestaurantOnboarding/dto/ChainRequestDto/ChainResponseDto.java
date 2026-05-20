package com.example.RestaurantOnboarding.dto.ChainRequestDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChainResponseDto {

    private Long chainId;
    private String name;
    private String ownerName;
}