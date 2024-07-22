package com.riwi.RiwiMarket.infrastructure.abstract_services;

import com.riwi.RiwiMarket.api.dtos.requests.ItemRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ItemResponse;

public interface IItemService extends GenericService<ItemRequest, ItemResponse, Long>{
}
