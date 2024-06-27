package com.riwi.RiwiMarket.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "item")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long quantity;
     @Column(nullable = false, columnDefinition = "DECIMAL(5,2)")
    private Double weight;
     @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
    private Double totalPrice;
    @Column(nullable = false)
    private Boolean status;
     @Column(columnDefinition = "DECIMAL(0,2)")
    private Double discount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",referencedColumnName = "id",nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id",referencedColumnName = "id",nullable = false)
    private Sale sale;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_return_id",referencedColumnName = "id",nullable = false)
    private Return returnn;
}
