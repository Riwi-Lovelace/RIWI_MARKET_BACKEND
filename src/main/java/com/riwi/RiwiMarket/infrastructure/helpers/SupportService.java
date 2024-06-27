package com.riwi.RiwiMarket.infrastructure.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.riwi.RiwiMarket.util.exceptions.BadIdException;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SupportService<Entity> {
    
    @Autowired
    JpaRepository<Entity, Long> repository;

    public Entity findById(Long id, String name) {
        return repository.findById(id)
                .orElseThrow(() -> new BadIdException(name));
    }

}
