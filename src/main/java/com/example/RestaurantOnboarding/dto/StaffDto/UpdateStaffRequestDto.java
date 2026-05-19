package com.example.RestaurantOnboarding.dto.StaffDto;

import com.example.RestaurantOnboarding.enums.StaffRole;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UpdateStaffRequestDto {

    private String name;

    @Pattern(regexp = "^[0-9]{10}$")
    private String phone;

    @Positive
    private Double salary;

    private StaffRole staffRole;

}
