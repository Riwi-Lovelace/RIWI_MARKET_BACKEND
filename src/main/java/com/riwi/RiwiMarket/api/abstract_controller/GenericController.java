package com.riwi.RiwiMarket.api.abstract_controller;

import com.riwi.RiwiMarket.api.dtos.requests.PocketRequest;
import com.riwi.RiwiMarket.api.dtos.responses.PocketResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GenericController<RequestDTO, ResponseDTO, ID> {

    ResponseEntity<ResponseDTO> create(RequestDTO request);

    ResponseEntity<ResponseDTO> read(ID id);

    ResponseEntity<ResponseDTO> update(RequestDTO request, ID id);

    ResponseEntity<Void> delete(ID id);

    interface IPocketController extends GenericController<PocketRequest, PocketResponse,Long>{
        ResponseEntity<List<PocketResponse>> getAll();
    }
}
