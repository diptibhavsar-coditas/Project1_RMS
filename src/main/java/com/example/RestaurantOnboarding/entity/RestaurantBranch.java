package com.example.RestaurantOnboarding.entity;

import com.example.RestaurantOnboarding.enums.GstType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "restaurant_branches")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantBranch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branchId;

    private String name;

    private String address;

    private String city;

    private String contactNumber;

    @Enumerated(EnumType.STRING)
    private GstType gstType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chain_id")
    private RestaurantChain restaurantChain;

}