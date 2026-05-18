package com.example.RestaurantOnboarding.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Restaurant_branch extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long r_id;

    private String Restaurant_name;

    private String address;
    private String city;
    private String state;

    private Long pincode;

    private String Gst_in;

    @ManyToOne
    @JoinColumn(name= "chain_id")
    private RestaurantChain restaurantChain;

    @ManyToOne
    @JoinColumn(name= "manager_id")
    private User manager;




}
