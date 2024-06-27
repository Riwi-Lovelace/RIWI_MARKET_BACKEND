package com.riwi.RiwiMarket.domain.entities;

import java.time.LocalDateTime;

import com.riwi.RiwiMarket.util.enums.MethodRefund;
import com.riwi.RiwiMarket.util.enums.ReasonRefund;

import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "refund")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Refund {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private MethodRefund method;
    @Column(nullable = false)
    private ReasonRefund reason;
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime date;
    
}
