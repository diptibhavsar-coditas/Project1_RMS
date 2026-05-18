package com.example.RestaurantOnboarding.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Staff extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long staff_id;

    private Long salary;
    private String photourl;

    private LocalDate joiningDate;

    private String status;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name ="branch_id")
    private Restaurant_branch branch;
}
