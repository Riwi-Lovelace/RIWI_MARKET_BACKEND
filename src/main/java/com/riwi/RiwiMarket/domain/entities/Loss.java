package com.riwi.RiwiMarket.domain.entities;

import com.riwi.RiwiMarket.domain.util.enums.Reason;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Loss {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    @Column(nullable = false)
    private LocalDateTime date;
    @Column(columnDefinition = "DECIMAL(5,2)")
    private BigDecimal weight;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Reason reason;
    private int batchId;
}
