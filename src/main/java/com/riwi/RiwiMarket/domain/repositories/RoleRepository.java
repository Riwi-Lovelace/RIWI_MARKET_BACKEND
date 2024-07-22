package com.riwi.RiwiMarket.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.RiwiMarket.domain.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
}
