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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/pockets")
@AllArgsConstructor
@Tag(name= "Pockets")
public class PocketController implements IPocketController {

    @Autowired
    private final IPocketService pocketService;

    @Override

    @Operation(summary = "Creat a pocket", description = "Creat a poket by sending the amount, the poket type CASH or BANK, and a description")
    @PostMapping
    public ResponseEntity<PocketResponse> create(@Validated @RequestBody PocketRequest request) {
        return ResponseEntity.ok(this.pocketService.create(request));
    }

    @Operation(summary = "Read a pocket by Id", description = "Read a pocket with its specific Id")
    @GetMapping(path = "/{id}")
    @Override
    public ResponseEntity<PocketResponse> read(Long id) {
        return ResponseEntity.ok(this.pocketService.read(id));
    }


    @PutMapping(path = "update/{id}")
    @Override
    @Operation(summary = "Update a pocket",description = "update any pocket selected by id")
    public ResponseEntity<PocketResponse> update(
            @Validated
            @RequestBody PocketRequest request,
            @PathVariable Long id) {

        PocketRequest pocketRequest = new PocketRequest();
        pocketRequest.setAmount(request.getAmount());
        pocketRequest.setDescription(request.getDescription());
        pocketRequest.setType(request.getType());

        return ResponseEntity.ok(this.pocketService.update(id,pocketRequest));
    }

    @Override
    @DeleteMapping(path = "delete/{id}")
    @Operation(summary = "delete a pocket",description = "delete any pocket selected by id")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.pocketService.delete(id);

        return ResponseEntity.noContent().build();
    }


    @Operation(summary = "Get all pockets" , description = "Get all pockets a store has")
    @GetMapping
    @Override
    public ResponseEntity<List<PocketResponse>> getAll(){

        return ResponseEntity.ok(this.pocketService.getAll());
    }
}
