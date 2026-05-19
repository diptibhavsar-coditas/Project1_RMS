package com.example.RestaurantOnboarding.service;

import com.example.RestaurantOnboarding.entity.Invitation;
import com.example.RestaurantOnboarding.repository.InvitationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class InvitationService {

    private final InvitationRepository invitationRepository;
    private final EmailService emailService;

    private final String FRONTEND_URL = "http://localhost:3000/register";

    public InvitationService(InvitationRepository invitationRepository,
                             EmailService emailService) {
        this.invitationRepository = invitationRepository;
        this.emailService = emailService;
    }

    public String sendInvitation(String email) {

        String token = UUID.randomUUID().toString();

        Invitation invitation = new Invitation();
        invitation.setEmail(email);
        invitation.setToken(token);
        invitation.setExpiryDate(LocalDateTime.now().plusDays(2));

        invitationRepository.save(invitation);

        String link = FRONTEND_URL + "?token=" + token;

        String message = "Welcome to Restaurant System!\n\n" +
                "Click the link below to register your restaurant:\n" +
                link + "\n\n" +
                "This link expires in 2 days.";

        emailService.sendEmail(email, "Restaurant Registration Invitation", message);

        return "Invitation sent successfully";
    }
}