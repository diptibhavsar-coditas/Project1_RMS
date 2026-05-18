package com.example.RestaurantOnboarding.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantChain extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chain_id;

    private String chain_name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

}
