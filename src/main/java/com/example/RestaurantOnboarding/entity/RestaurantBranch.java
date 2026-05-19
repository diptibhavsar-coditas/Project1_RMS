package com.example.RestaurantOnboarding.entity;


import com.example.RestaurantOnboarding.enums.GstCategory;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "restaurant_branches")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantBranch extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branchId;

    private String branchName;

    private String city;

    private String address;

    @Enumerated(EnumType.STRING)
    private GstCategory gstType;

    private Boolean hasLiquor;

    @ManyToOne
    @JoinColumn(name = "chain_id")
    private RestaurantChain restaurantChain;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private User manager;




}
