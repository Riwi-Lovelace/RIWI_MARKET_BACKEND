package com.riwi.RiwiMarket.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity(name = "stock")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    @Column(columnDefinition = "DECIMAL(5,2)")
    private BigDecimal weight;

    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private BigDecimal purchasePrice;

    @OneToMany(fetch = FetchType.EAGER,
    mappedBy = "stock",
    cascade = CascadeType.ALL)
    private List<Batch> batch;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    private Stock stock;

}
