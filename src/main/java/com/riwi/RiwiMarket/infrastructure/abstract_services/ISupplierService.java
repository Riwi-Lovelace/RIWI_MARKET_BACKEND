package com.riwi.RiwiMarket.infrastructure.abstract_services;

import java.util.List;

import com.riwi.RiwiMarket.api.dtos.requests.SupplierRequest;
import com.riwi.RiwiMarket.api.dtos.responses.SupplierResponse;
import com.riwi.RiwiMarket.domain.entities.Supplier;

public interface ISupplierService extends GenericService<SupplierRequest, SupplierResponse ,Long>{
    public final String FIELD_BY_SORT = "name";
    public List<Supplier> findByName(String name);
    public List<Supplier> findByContact(String contact);
    public List<Supplier> findByAddress(String address);
    public List<Supplier> findByStatus(Boolean status);
}
