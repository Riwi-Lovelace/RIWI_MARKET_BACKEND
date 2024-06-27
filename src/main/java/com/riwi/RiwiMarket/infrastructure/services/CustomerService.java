package com.riwi.RiwiMarket.infrastructure.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.RiwiMarket.api.dtos.requests.CustomerRequest;
import com.riwi.RiwiMarket.api.dtos.responses.CustomerResponse;
import com.riwi.RiwiMarket.domain.entities.Customer;
import com.riwi.RiwiMarket.domain.repositories.CustomerRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.ICustomerService;
import com.riwi.RiwiMarket.infrastructure.helpers.SupportService;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.CustomerMapper;
import com.riwi.RiwiMarket.util.enums.SortCustomer;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService implements ICustomerService{

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final SupportService<Customer> supportService;

    @Override
    public CustomerResponse create(CustomerRequest request) {
        Customer customer = this.customerMapper.toUserEntity(request);
        return this.customerMapper.toUserResponse(this.customerRepository.save(customer));
    }

    @Override
    public CustomerResponse read(Long id) {
        Customer customer = (Customer) this.supportService.findById(id, "Customer");
        return this.customerMapper.toUserResponse(customer);
    }

    @Override
    public CustomerResponse update(Long id, CustomerRequest request) {
        Customer customer = this.findIdCustomer(id);
        customer = this.customerMapper.toUserEntity(request);
        customer.setId(id);
        return this.customerMapper.toUserResponse(this.customerRepository.save(customer));
    }

    @Override // Customer cannot be deleted
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    public Page<CustomerResponse> getAll(int size, int page, SortCustomer sortCustomer){
        if (page < 0) page = 0;

        PageRequest pagination = null;

        switch(sortCustomer){
            case NONE -> pagination  = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_SORT).descending());
        }

        return this.customerRepository.findAll(pagination).map(this.customerMapper::toUserResponse);
    }

    private Customer findIdCustomer(Long id){
        Customer customer = (Customer) this.supportService.findById(id, "Customer");
        return customer;
    }
}
