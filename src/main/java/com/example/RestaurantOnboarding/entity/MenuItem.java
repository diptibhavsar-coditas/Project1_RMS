package com.example.RestaurantOnboarding.entity;

import com.example.RestaurantOnboarding.enums.DishCategory;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "menu_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    private String itemName;

    @Enumerated(EnumType.STRING)
    private DishCategory category;

    private Double price;

    private Integer calories;

    @Column(length = 1000)
    private String description;

    private String spicyLevel;

    private String allergens;

    private String specialInstructions;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private MenuCategory menuCategory;

    @OneToMany(mappedBy = "menuItem")
    private List<DishImage> images;
}