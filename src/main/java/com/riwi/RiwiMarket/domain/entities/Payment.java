package com.riwi.RiwiMarket.domain.entities;

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

@Entity(name = "payment")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
    private Double amount;
    @Column(nullable = false)
    private String type;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "payment",
            cascade = CascadeType.ALL,
            orphanRemoval = false
    )
    private List<SalePayment> salePayments;
}
