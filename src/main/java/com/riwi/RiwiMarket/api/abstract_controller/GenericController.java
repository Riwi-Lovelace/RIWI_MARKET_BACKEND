package com.riwi.RiwiMarket.api.abstract_controller;

import org.springframework.http.ResponseEntity;

public interface GenericController<RequestDTO, ResponseDTO, ID> {

    ResponseEntity<ResponseDTO> create(RequestDTO request);

    ResponseEntity<ResponseDTO> read(ID id);

    ResponseEntity<ResponseDTO> update(RequestDTO request, ID id);

    ResponseEntity<Void> delete(ID id);

}
