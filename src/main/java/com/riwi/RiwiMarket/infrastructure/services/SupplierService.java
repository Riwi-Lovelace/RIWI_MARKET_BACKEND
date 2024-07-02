package com.riwi.RiwiMarket.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.RiwiMarket.api.dtos.requests.SupplierRequest;
import com.riwi.RiwiMarket.api.dtos.responses.SupplierResponse;
import com.riwi.RiwiMarket.domain.entities.Supplier;
import com.riwi.RiwiMarket.domain.repositories.SupplierRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.ISupplierService;
import com.riwi.RiwiMarket.infrastructure.helpers.SupportService;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.SupplierMapper;
import com.riwi.RiwiMarket.util.exceptions.BadIdException;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class SupplierService implements ISupplierService{

    @Autowired
    private final SupportService<Supplier> Supportsupplier;
    @Autowired
    private final SupplierMapper supplierMapper;

    @Autowired
    private final SupplierRepository supplierRepository;

    @Override
    public SupplierResponse create(SupplierRequest request) {
        Supplier supplier = supplierMapper.toUserEntity(request);
        supplier.setStatus(true);
        return supplierMapper.toUserResponse((this.supplierRepository.save(supplier)));
    }

    // Search by id
    @Override
    public SupplierResponse read(Long id) {

        Supplier supplier = supplierRepository.findById(id)
                    .orElseThrow(()  -> new BadIdException("Supplier not found with ID: " + id));

        return supplierMapper.toUserResponse(supplier);
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

  // FindByName
    @Override
    public Page<SupplierResponse> findByName(String name, Pageable pageable) {

        return supplierRepository.findByName(name, pageable).map(supplierMapper::toUserResponse);
    }

    // findByContact
    @Override
    public Page<SupplierResponse> findByContact(String contact, Pageable pageable) {

        return supplierRepository.findByContact(contact, pageable).map(supplierMapper::toUserResponse);
    }

    // findByAddress
    @Override
    public Page<SupplierResponse> findByAddress(String address, Pageable pageable) {

        return supplierRepository.findByAddress(address, pageable).map(supplierMapper::toUserResponse);
    }

    // findByStatus
    @Override
    public Page<SupplierResponse> findByStatus(Boolean status, Pageable pageable) {

        return supplierRepository.findByStatus(status, pageable).map(supplierMapper::toUserResponse);
    }

    // findAll
    @Override
    public Page<SupplierResponse> findAll(Pageable pageable) {

        return supplierRepository.findAll(pageable).map(supplierMapper::toUserResponse);
    }
}
