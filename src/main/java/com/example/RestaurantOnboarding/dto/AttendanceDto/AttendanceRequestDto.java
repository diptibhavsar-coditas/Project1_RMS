package com.example.RestaurantOnboarding.dto.AttendanceDto;

import com.example.RestaurantOnboarding.enums.AttendanceStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AttendanceRequestDto {

    @NotNull
    private Long staffId;

    @NotNull
    private LocalDate date;

    @NotNull
    private AttendanceStatus status;
}
