package com.riwi.RiwiMarket.infrastructure.helpers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.riwi.RiwiMarket.util.exceptions.BadIdException;
import lombok.AllArgsConstructor;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class SupportService<Entity> {
    public Entity findById(JpaRepository<Entity, Long> repository, Long id, String name) {
        return repository.findById(id)
                .orElseThrow(() -> new BadIdException(name));
    }

}
