package com.riwi.RiwiMarket.domain.entities;

import java.math.BigDecimal;
import com.riwi.RiwiMarket.util.enums.TypePocket;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "pocket")
@Getter
@Setter
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
    @Enumerated(EnumType.STRING)
    private TypePocket type;

    @Column(columnDefinition = "TEXT")
    private String description;
}
