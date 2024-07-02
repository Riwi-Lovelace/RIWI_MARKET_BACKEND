package com.riwi.RiwiMarket.infrastructure.helpers;

import org.springframework.data.jpa.repository.JpaRepository;
import com.riwi.RiwiMarket.util.exceptions.BadIdException;
import org.springframework.stereotype.Component;

@Component
public class SupportService<Entity> {
    public Entity findById(JpaRepository<Entity, Long> repository, Long id, String name) {
        return repository.findById(id)
                .orElseThrow(() -> new BadIdException(name));
    }
}
