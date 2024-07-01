package com.riwi.RiwiMarket.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

@Entity(name = "batch")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Batch {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime expiration;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime entryDate;
}
