package com.example.RestaurantOnboarding.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "audit_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLog extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auditId;

    @Column(nullable = false)
    private String action;

    @Column(nullable = false)
    private String moduleName;

    @Column(length = 3000)
    private String description;

    private String performedBy;
}