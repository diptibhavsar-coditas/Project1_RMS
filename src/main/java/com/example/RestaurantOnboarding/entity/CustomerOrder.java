package com.example.RestaurantOnboarding.entity;

import com.example.RestaurantOnboarding.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.net.ProtocolFamily;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Double totalAmount;

    private Integer totalItems;

    private LocalDateTime orderTime;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private RestaurantBranch branch;

    @OneToOne(mappedBy = "order")
    private BillInvoice billInvoice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table_id")
    private TableAssignment table;
}