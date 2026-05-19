package com.example.RestaurantOnboarding.dto.BranchDto;

import com.example.RestaurantOnboarding.enums.GstCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBranchRequestDto {

    @NotBlank
    private String name;

    @NotBlank
    private String location;

    @NotNull
    private Long chainId;

    @NotNull
    private GstCategory gstType;


}
