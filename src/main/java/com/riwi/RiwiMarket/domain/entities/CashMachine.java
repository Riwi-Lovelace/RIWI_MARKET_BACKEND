package com.riwi.RiwiMarket.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "cash_machine")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CashMachine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
    private BigDecimal initialBalance;

    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
    private BigDecimal balance;
}
