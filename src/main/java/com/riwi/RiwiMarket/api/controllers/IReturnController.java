package com.riwi.RiwiMarket.api.controllers;

import com.riwi.RiwiMarket.api.dtos.requests.ReturnRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ReturnResponse;
import com.riwi.RiwiMarket.domain.entities.Return;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IReturnController extends GenericController<ReturnRequest, ReturnResponse, Long>{

    ResponseEntity<List<ReturnResponse>> getAll();

    ResponseEntity<List<ReturnResponse>> getByMethod();

    ResponseEntity<List<ReturnResponse>> getByReason();
}
