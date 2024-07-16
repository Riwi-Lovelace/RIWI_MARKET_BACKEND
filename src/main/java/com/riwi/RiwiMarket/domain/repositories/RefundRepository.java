package com.riwi.RiwiMarket.domain.repositories;

import com.riwi.RiwiMarket.domain.entities.Refund;
import com.riwi.RiwiMarket.util.enums.Method;
import com.riwi.RiwiMarket.util.enums.Reason;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RefundRepository extends JpaRepository<Refund, Long>{

    List<Refund> findByMethod(Method method);

    List<Refund> findByReason(Reason reason);

    Page<Refund> findByMethodOrReasonOrDateBetween(Method method, Reason reason, LocalDateTime startDate, LocalDateTime endDate, PageRequest pageRequest);
}
