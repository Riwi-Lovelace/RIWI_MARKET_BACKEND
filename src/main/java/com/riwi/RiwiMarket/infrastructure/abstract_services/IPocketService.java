package com.riwi.RiwiMarket.infrastructure.abstract_services;

import com.riwi.RiwiMarket.api.dtos.requests.PocketRequest;
import com.riwi.RiwiMarket.api.dtos.responses.PocketResponse;

public interface IPocketService extends  GenericService<PocketRequest, PocketResponse, Long>{
    PocketResponse getAll();
}
