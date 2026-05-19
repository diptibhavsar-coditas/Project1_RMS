package com.example.RestaurantOnboarding.entity;

import com.example.RestaurantOnboarding.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "customer_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerOrder extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus orderStatus;

    @Column(nullable = false)
    private Integer totalItems;

    @Column(nullable = false)
    private Boolean paymentDone = false;

    @Column(length = 1000)
    private String customerNote;

    private LocalDateTime orderTime;

    private LocalDateTime completedTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table_id", nullable = false)
    private TableMaster table;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "waiter_id", nullable = false)
    private Staff waiter;

    @OneToMany(
            mappedBy = "customerOrder",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OrderItem> orderItems;

    @OneToOne(
            mappedBy = "customerOrder",
            cascade = CascadeType.ALL
    )
    private Discount discount;

    @OneToOne(
            mappedBy = "customerOrder",
            cascade = CascadeType.ALL
    )
    private BillInvoice billInvoice;
}