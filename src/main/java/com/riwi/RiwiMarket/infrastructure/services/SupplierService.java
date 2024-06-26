package com.riwi.RiwiMarket.infrastructure.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.RiwiMarket.api.dtos.requests.SupplierRequest;
import com.riwi.RiwiMarket.api.dtos.responses.SupplierResponse;
import com.riwi.RiwiMarket.domain.entities.Supplier;
import com.riwi.RiwiMarket.domain.repositories.SupplierRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.ISupplierService;
import com.riwi.RiwiMarket.infrastructure.helpers.SupportService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class SupplierService implements ISupplierService{

    @Autowired
    private final SupportService<Supplier> Supportsupplier;

    @Autowired
    private final SupplierRepository supplierRepository;

    @Override
    public SupplierResponse create(SupplierRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public SupplierResponse read(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public SupplierResponse update(Long id, SupplierRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Supplier> findByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByName'");
    }

    @Override
    public List<Supplier> findByContact(String contact) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByContact'");
    }

    @Override
    public List<Supplier> findByAddress(String address) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByAddress'");
    }

    @Override
    public List<Supplier> findByStatus(Boolean status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByStatus'");
    }
    
}
