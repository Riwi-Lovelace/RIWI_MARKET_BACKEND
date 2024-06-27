package com.riwi.RiwiMarket.domain.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "discount")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Discount {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, columnDefinition = "DECIMAL(2,2)")
    private Double amount;
    @Column(length = 100)
    private String description;
    private LocalDateTime startDiscount;
    private LocalDateTime endDiscount;
    @Column(nullable = false)
    private Boolean status;
}
