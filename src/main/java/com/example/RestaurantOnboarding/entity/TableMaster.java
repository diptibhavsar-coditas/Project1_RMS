package com.example.RestaurantOnboarding.entity;

import com.example.RestaurantOnboarding.enums.TableStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "table_master")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TableMaster extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tableId;

    private Integer tableNumber;

    private Integer capacity;

    @Enumerated(EnumType.STRING)
    private TableStatus status;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private RestaurantBranch branch;
}