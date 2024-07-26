package com.riwi.RiwiMarket.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

@Entity(name = "batch")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime expiration;

    private Integer quantity;

    @Column(columnDefinition = "DECIMAL(5,2)")
    private BigDecimal weight;

    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private BigDecimal purchasePrice;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime entryDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", 
    referencedColumnName = "id")
    private Product product;

    @OneToOne(mappedBy = "batch", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Stock stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id",
            referencedColumnName = "id")
    private Supplier supplier;

    @OneToMany(fetch = FetchType.EAGER,
    mappedBy = "batch",
    cascade = CascadeType.ALL)
    private List<Loss> losses;


}
