package com.riwi.RiwiMarket.domain.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "discount")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Discount {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, columnDefinition = "DECIMAL(0,2)")
    private Double amount;
    @Column(length = 100)
    private String description;
    private LocalDateTime startDiscount;
    private LocalDateTime endDiscount;
    @Column(nullable = false)
    private Boolean status;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "discount",
            cascade = CascadeType.ALL,
            orphanRemoval = false
    )
    private List<SaleDiscount> saleDiscounts;
}
