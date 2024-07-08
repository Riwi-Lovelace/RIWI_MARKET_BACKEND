package com.riwi.RiwiMarket.infrastructure.abstract_services;

import org.springframework.data.domain.Page;
import com.riwi.RiwiMarket.api.dtos.requests.SupplierRequest;
import com.riwi.RiwiMarket.api.dtos.responses.SupplierResponse;


public interface ISupplierService extends GenericService<SupplierRequest, SupplierResponse ,Long>{

    public final String FIELD_BY_SORT = "name";

    Page<SupplierResponse> findByAddressContainingOrContactContainingOrNameContaining(int page, int size, String name, String contact, String address);
    void disableSuplier(Long id);
}
