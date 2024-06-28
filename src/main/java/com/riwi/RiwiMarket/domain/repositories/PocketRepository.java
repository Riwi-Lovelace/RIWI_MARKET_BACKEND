package com.riwi.RiwiMarket.domain.repositories;

import com.riwi.RiwiMarket.domain.entities.Pocket;
import com.riwi.RiwiMarket.util.enums.TypePocket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PocketRepository extends JpaRepository<Pocket,Long> {
    List<Pocket> findByType(TypePocket type);
}
