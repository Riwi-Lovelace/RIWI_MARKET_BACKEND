package com.riwi.RiwiMarket.domain.entities;

import java.math.BigDecimal;
import java.util.List;

import com.riwi.RiwiMarket.util.enums.TypePocket;

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
import lombok.NoArgsConstructor;

@Entity(name = "pocket")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pocket {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
    private BigDecimal amount;
    @Column(nullable = false)
    private TypePocket type;
    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(fetch = FetchType.EAGER,
     mappedBy = "pocketId",
     cascade = CascadeType.ALL,
     orphanRemoval = false)
    private List<PaymentExpense> paymentExpenses;
}
