package com.example.RestaurantOnboarding.entity;

import com.example.RestaurantOnboarding.enums.TableStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    private Integer capacity;

    @Enumerated(EnumType.STRING)
    private TableStatus status;


    @OneToMany(mappedBy = "tableMaster")
    private List<TableAssignment> assignments;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private RestaurantBranch branch;
}