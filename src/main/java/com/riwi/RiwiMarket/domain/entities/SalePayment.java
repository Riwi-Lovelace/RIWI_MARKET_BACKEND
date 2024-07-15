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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "sale_payment")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalePayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id" , referencedColumnName = "id")
    private Payment paymentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_id" , referencedColumnName = "id")
    private Sale saleId;
}
