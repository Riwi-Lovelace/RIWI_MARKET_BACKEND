package com.riwi.RiwiMarket.api.controllers;

import com.riwi.RiwiMarket.api.abstract_controller.IPocketController;
import com.riwi.RiwiMarket.api.dtos.requests.PocketRequest;
import com.riwi.RiwiMarket.api.dtos.responses.PocketResponse;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IPocketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/pockets")
@AllArgsConstructor
@Tag(name = "Pockets")
public class PocketController implements IPocketController {

    @Autowired
    private final IPocketService pocketService;

    @Override
    public ResponseEntity<PocketResponse> create(PocketRequest request) {
        return null;
    }

    @Operation(summary = "Read a pocket by Id", description = "Read a pocket with its specific Id")
    @GetMapping(path = "/{id}")
    @Override
    public ResponseEntity<PocketResponse> read(Long id) {
        return ResponseEntity.ok(this.pocketService.read(id));
    }

    @Override
    public ResponseEntity<PocketResponse> update(PocketRequest request, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<PocketResponse>> getAll() {
        return null;
    }
}
