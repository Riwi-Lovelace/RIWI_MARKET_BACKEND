package com.riwi.RiwiMarket.domain.entities;

import com.riwi.RiwiMarket.util.enums.Reason;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "loss")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Loss {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Integer quantity;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(columnDefinition = "DECIMAL(5,2)")
    private BigDecimal weight;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Reason reason;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "batch_id", referencedColumnName = "id")
    private Batch batch;

    
}
