package com.riwi.RiwiMarket.domain.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "available")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Available {
    
    @Id
    private Long id;
    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
    private Double balance;
    @Column(nullable = false)
    private LocalDateTime date;
}
