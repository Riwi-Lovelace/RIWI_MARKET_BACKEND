package com.riwi.RiwiMarket.infrastructure.services;

import com.riwi.RiwiMarket.api.dtos.requests.StoreRequest;
import com.riwi.RiwiMarket.api.dtos.responses.StoreResponse;
import com.riwi.RiwiMarket.domain.entities.Store;
import com.riwi.RiwiMarket.domain.repositories.StoreRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IStoreService;
import com.riwi.RiwiMarket.infrastructure.helpers.SupportService;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.StoreMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StoreService implements IStoreService {

    @Autowired
    private final StoreRepository storeRepository;

    @Autowired
    private final StoreMapper storeMapper;

    @Autowired
    private final SupportService<Store> supportService;

    @Override
    public StoreResponse create(StoreRequest request) {
        Store store = this.storeMapper.toEntity(request);
        store.setAvailable(new BigDecimal(0));
        store.setAddress(request.getAddress());
        store.setEmployees(new ArrayList<>());

        return this.storeMapper.toResponse(this.storeRepository.save(store));
    }

    @Override
    public StoreResponse read(Long id) {
        return null;
    }

    @Override
    public StoreResponse update(Long id, StoreRequest request) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Page<StoreResponse> getAll(int page, int size) {
        return null;
    }

    //function to convert ArrayList of an entity to Page of entity
    private <T> Page<T> convertListToPage(List<T> list, int page, int size) {
        int start = (int) PageRequest.of(page, size).getOffset();
        int end = Math.min((start + PageRequest.of(page, size).getPageSize()), list.size());
        List<T> subList = list.subList(start, end);
        return new PageImpl<>(subList, PageRequest.of(page, size), list.size());
    }
}
