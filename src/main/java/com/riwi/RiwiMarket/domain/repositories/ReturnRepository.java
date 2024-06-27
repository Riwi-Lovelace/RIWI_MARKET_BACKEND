package com.riwi.RiwiMarket.domain.repositories;

import com.riwi.RiwiMarket.domain.entities.Return;
import com.riwi.RiwiMarket.util.enums.MethodReturn;
import com.riwi.RiwiMarket.util.enums.ReasonReturn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ReturnRepository extends JpaRepository<Return, Long>{

    List<Return> findByReason(MethodReturn method);

    List<Return> findByReason(ReasonReturn reason);
}
