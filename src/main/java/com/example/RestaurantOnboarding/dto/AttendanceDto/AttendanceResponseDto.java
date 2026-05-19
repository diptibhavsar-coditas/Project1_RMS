package com.example.RestaurantOnboarding.dto.AttendanceDto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AttendanceResponseDto {

    private Long id;
    private String staffName;
    private String status;
    private LocalDate date;
}