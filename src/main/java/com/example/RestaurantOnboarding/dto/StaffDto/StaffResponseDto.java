package com.example.RestaurantOnboarding.dto.StaffDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StaffResponseDto {

    private Long id;
    private String name;
    private String phone;
    private String email;
    private String staffRole;
    private Double salary;
    private String branchName;
}