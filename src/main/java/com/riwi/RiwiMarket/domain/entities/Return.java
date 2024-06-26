package com.riwi.RiwiMarket.domain.entities;

import java.time.LocalDateTime;

import com.riwi.RiwiMarket.util.enums.Method;
import com.riwi.RiwiMarket.util.enums.Reason;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "return")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Return {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Method method;
    @Column(nullable = false)
    private Reason reason ;
    @Column(nullable = false)
    private LocalDateTime date;
    
}
