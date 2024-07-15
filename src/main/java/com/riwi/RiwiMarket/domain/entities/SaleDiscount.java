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

@Entity(name = "sale_discount")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleDiscount {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discount_id" , referencedColumnName = "id")
    private Discount discountId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_id" , referencedColumnName = "id")
    private Sale saleId;
}
