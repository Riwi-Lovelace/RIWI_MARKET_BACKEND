package com.riwi.RiwiMarket.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;

import com.riwi.RiwiMarket.api.dtos.requests.SupplierRequest;
import com.riwi.RiwiMarket.api.dtos.responses.SupplierResponse;
import com.riwi.RiwiMarket.domain.entities.Supplier;
import com.riwi.RiwiMarket.domain.repositories.SupplierRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.ISupplierService;
import com.riwi.RiwiMarket.infrastructure.helpers.SupportService;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.SupplierMapper;
import com.riwi.RiwiMarket.util.exceptions.BadIdException;
import com.riwi.RiwiMarket.util.exceptions.BadRequestException;

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
        Supplier supplier = supplierMapper.toEntity(request);
        supplier.setStatus(true);
        return supplierMapper.toResponse((this.supplierRepository.save(supplier)));
    }

    // Search by id
    @Override
    public SupplierResponse read(Long id) {

        Supplier supplier = supplierRepository.findById(id)
                    .orElseThrow(()  -> new BadIdException("Supplier not found with ID: " + id));

        return supplierMapper.toResponse(supplier);
    }

    @Override
    public SupplierResponse update(Long id, SupplierRequest request) {
        Supplier supplier = this.find(id);
        supplier = supplierMapper.toEntity(request);
        supplier.setId(id);

        return supplierMapper.toResponse(this.supplierRepository.save(supplier));
    }

    public void disableSuplier(Long id) {
        Supplier existingSupplier = supplierRepository.findById(id)
        .orElseThrow(() -> new BadRequestException("Supplier not found"));
        if(existingSupplier.getStatus() == true){
            existingSupplier.setStatus(false);
        }else {
            existingSupplier.setStatus(true);
        }
        supplierRepository.save(existingSupplier);
    }
    
    
    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    private Supplier find(Long id) {
        return this.supplierRepository.findById(id)
        .orElseThrow(()-> new BadRequestException("supplier"));
    }

  
    @Override
    public Page<SupplierResponse> findByAddressContainingOrContactContainingOrNameContaining(
        int page, int size, String name, String contact, String address) {
    
    PageRequest pageRequest = PageRequest.of(page, size);

    if (name.equals("") && address.equals("") && contact.equals("")){
        address="";
        name="";
        contact="";

    }else {
        if (contact.equals("")){
            contact=" ";
        }
        if (address.equals("")){
            address=" ";
        }
        if (name.equals("")){
            name=" ";
        }
    }

    
    Page<SupplierResponse> pageEntity =  this.supplierRepository.findByAddressContainingOrContactContainingOrNameContaining(address,contact,name,pageRequest).map(this::convertir);

    return pageEntity;

}
    public SupplierResponse convertir(Supplier supplier) {
        return this.supplierMapper.toResponse(supplier);
    }




    

}
