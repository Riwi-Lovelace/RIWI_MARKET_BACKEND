package com.riwi.RiwiMarket.domain.entities;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "item")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    @Column(columnDefinition = "DECIMAL(5,2)")
    private BigDecimal weight;

    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
    private BigDecimal totalPrice;

    @Column(nullable = false)
    private Boolean status;

    @Column(columnDefinition = "DECIMAL(2,2)")
    private Double discount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @OneToMany(mappedBy = "itemId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Refund> refundId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_id" , referencedColumnName = "id")
    private Sale saleId;
}
