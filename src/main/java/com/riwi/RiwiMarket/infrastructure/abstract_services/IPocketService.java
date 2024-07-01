package com.riwi.RiwiMarket.infrastructure.abstract_services;

import com.riwi.RiwiMarket.api.dtos.requests.PocketRequest;
import com.riwi.RiwiMarket.api.dtos.responses.PocketResponse;

import java.util.List;

public interface IPocketService extends GenericService<PocketRequest, PocketResponse, Long>{
    List<PocketResponse> getAll();
}
