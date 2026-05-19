package com.example.RestaurantOnboarding.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bill_invoices")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillInvoice extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double subtotal;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double gstAmount;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double vatAmount;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double discountAmount;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double finalAmount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private CustomerOrder customerOrder;


    public void setOrder(CustomerOrder order) {
        this.customerOrder =order;
    }

    public void setTotalAmount(double total) {
        this.finalAmount=total;
    }

}
