package com.riwi.RiwiMarket.infrastructure.helpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.RiwiMarket.util.exceptions.BadIdException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SupportService<Entity> {

    @Autowired
    JpaRepository<Entity, Long> repository;

    public Entity findById(Long id, String name) {
        return repository.findById(id)
                .orElseThrow(() -> new BadIdException(name));
    }
}
