package com.example.RestaurantOnboarding.dto.StaffDto;

import com.example.RestaurantOnboarding.enums.StaffRole;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStaffRequestDto {

    @NotBlank
    private String name;

    @Pattern(regexp = "^[0-9]{10}$")
    private String phone;

    @Email
    private String email;

    @NotNull
    private StaffRole staffRole;

    @Positive
    private Double salary;

    @NotNull
    private Long branchId;


}