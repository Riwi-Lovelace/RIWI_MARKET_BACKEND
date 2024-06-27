package com.riwi.RiwiMarket.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "sale_payment")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalePayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_payment_id",referencedColumnName = "id",nullable = false)
    private SalePayment salePayment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id",referencedColumnName = "id",nullable = false)
    private Payment Payment;

}
