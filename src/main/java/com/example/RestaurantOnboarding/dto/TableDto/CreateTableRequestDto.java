package com.example.RestaurantOnboarding.dto.TableDto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTableRequestDto {

    @NotNull
    private Integer tableNumber;

    @NotNull
    @Min(1)
    @Max(20)
    private Integer capacity;

    @NotNull
    private Long branchId;
}