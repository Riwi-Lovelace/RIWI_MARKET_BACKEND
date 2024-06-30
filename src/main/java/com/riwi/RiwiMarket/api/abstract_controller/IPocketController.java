package com.riwi.RiwiMarket.api.abstract_controller;

import com.riwi.RiwiMarket.api.dtos.requests.PocketRequest;
import com.riwi.RiwiMarket.api.dtos.responses.PocketResponse;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPocketController extends GenericController<PocketRequest, PocketResponse,Long>{
    ResponseEntity<List<PocketResponse>> getAll();
}
