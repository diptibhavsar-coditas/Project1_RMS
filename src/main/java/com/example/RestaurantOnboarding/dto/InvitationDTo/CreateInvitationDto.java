package com.example.RestaurantOnboarding.dto.InvitationDTo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateInvitationDto {

    @Email
    private String email;

    @NotNull
    private Long branchId;
}