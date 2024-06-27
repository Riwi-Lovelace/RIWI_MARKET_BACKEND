package com.riwi.RiwiMarket.api.controllers;

import com.riwi.RiwiMarket.api.dtos.requests.ReturnRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ReturnResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping(path = "/Return")
@AllArgsConstructor
public class ReturnController implements IReturnController{

    @Override
    public ResponseEntity<ReturnResponse> create(ReturnRequest request) {
        return null;
    }

    @GetMapping(path = "/{id}")
    @Override
    public ResponseEntity<ReturnResponse> read(Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<List<ReturnResponse>> getAll() {
        return null;
    }

    @GetMapping(path = "/{method}")
    @Override
    public ResponseEntity<List<ReturnResponse>> getByMethod() {
        return null;
    }

    @GetMapping(path = "/{reason}")
    @Override
    public ResponseEntity<List<ReturnResponse>> getByReason() {
        return null;
    }

    @Override
    public ResponseEntity<ReturnResponse> update(ReturnRequest request, Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(Long aLong) {
        return null;
    }

}
