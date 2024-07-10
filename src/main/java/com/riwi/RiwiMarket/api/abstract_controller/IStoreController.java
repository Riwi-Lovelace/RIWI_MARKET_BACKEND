package com.riwi.RiwiMarket.api.abstract_controller;

import com.riwi.RiwiMarket.api.dtos.requests.StoreRequest;
import com.riwi.RiwiMarket.api.dtos.responses.StoreResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface IStoreController extends GenericController<StoreRequest, StoreResponse,Long> {
    ResponseEntity<Page<StoreResponse>> getAll();
}
