package com.example.RestaurantOnboarding.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "dish_images")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DishImage extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "menu_item_id")
    private MenuItem menuItem;
}
