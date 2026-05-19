package com.example.RestaurantOnboarding.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "daily_reports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DailyReport extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    private LocalDate reportDate;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalSales;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalExpenses;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal netProfit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id", nullable = false)
    private RestaurantBranch branch;
}
