package com.example.RestaurantOnboarding.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;

    private String category_name;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Restaurant_branch branch;
}
