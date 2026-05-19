package com.example.RestaurantOnboarding.entity;

import com.example.RestaurantOnboarding.enums.StaffRole;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "staff")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Staff extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long staffId;

    private String fullName;

    private String email;

    private String phone;

    private String photo;

    @Enumerated(EnumType.STRING)
    private StaffRole role;

    private BigDecimal salary;

    private LocalDate joiningDate;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private RestaurantBranch branch;
}
