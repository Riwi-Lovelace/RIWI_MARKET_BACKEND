package com.riwi.RiwiMarket.api.controllers;

import com.riwi.RiwiMarket.api.dtos.requests.PocketRequest;
import com.riwi.RiwiMarket.api.dtos.responses.PocketResponse;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IPocketService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/pockets")
@AllArgsConstructor
public class PocketController implements IPocketController {

    @Autowired
    private final IPocketService pocketService;

    @Override
    public ResponseEntity<PocketResponse> create(PocketRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<PocketResponse> read(Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<PocketResponse> update(PocketRequest request, Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<List<PocketResponse>> getAll(){
        return null;
    }
}
