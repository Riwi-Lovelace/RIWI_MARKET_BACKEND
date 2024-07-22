package com.riwi.RiwiMarket.infrastructure.services;

import com.riwi.RiwiMarket.api.dtos.requests.ItemRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ItemResponse;
import com.riwi.RiwiMarket.domain.repositories.ItemRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IItemService;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.ItemMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemService implements IItemService {
    @Autowired
    private final ItemMapper itemMapper;
    @Autowired
    private final ItemRepository itemRepository;



    @Override
    public ItemResponse create(ItemRequest request) {

    return null;

    }

    @Override
    public ItemResponse read(Long aLong) {
        return null;
    }

    @Override
    public ItemResponse update(Long aLong, ItemRequest request) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
