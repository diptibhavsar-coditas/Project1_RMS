package com.example.RestaurantOnboarding.controller;

import com.example.RestaurantOnboarding.exception.ApiResponse;
import com.example.RestaurantOnboarding.service.InvitationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invitation")
public class InvitationController {

    private final InvitationService invitationService;

    public InvitationController(InvitationService invitationService) {
        this.invitationService = invitationService;
    }

    @PostMapping("/send")
    public ResponseEntity<ApiResponse<String>> sendInvitation(
            @RequestParam String email) {

        return ResponseEntity.ok(
                new ApiResponse<>(true,
                        "Invitation sent",
                        invitationService.sendInvitation(email))
        );
    }
}