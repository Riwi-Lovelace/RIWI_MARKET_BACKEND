package com.riwi.RiwiMarket.infrastructure.abstract_services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.riwi.RiwiMarket.api.dtos.requests.SupplierRequest;
import com.riwi.RiwiMarket.api.dtos.responses.SupplierResponse;

public interface ISupplierService extends GenericService<SupplierRequest, SupplierResponse ,Long>{

    public final String FIELD_BY_SORT = "name";
    
    public Page<SupplierResponse> findByName(String name, Pageable pageable);
    public Page<SupplierResponse> findByContact(String contact, Pageable pageable);
    public Page<SupplierResponse> findByAddress(String address, Pageable pageable);
    public Page<SupplierResponse> findByStatus(Boolean status, Pageable pageable);

    public Page<SupplierResponse> findAll(Pageable pageable);
}
