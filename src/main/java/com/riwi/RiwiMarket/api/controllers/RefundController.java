package com.riwi.RiwiMarket.api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.riwi.RiwiMarket.api.dtos.requests.RefundRequest;
import com.riwi.RiwiMarket.api.dtos.requests.RefundRequestGetAll;
import com.riwi.RiwiMarket.api.dtos.responses.RefundResponse;
import com.riwi.RiwiMarket.api.abstract_controller.IRefundController;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IRefundService;
import com.riwi.RiwiMarket.util.enums.Method;
import com.riwi.RiwiMarket.util.enums.Reason;

import lombok.AllArgsConstructor;
import java.time.LocalDate;

@RestController
@RequestMapping(path = "/refund")
@Tag(name = "Refund Controller")
@AllArgsConstructor
public class RefundController implements IRefundController {
    @Autowired
    private final IRefundService refundService;

    @Override
    @Operation(summary = "Create refund", description = "Add new refund.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation. Create new refund."),
            @ApiResponse(responseCode = "400", description = "Bad request. This occur if the parameters are invalid."),
            @ApiResponse(responseCode = "404", description = "Refunds with the incorrect request")
    })
    @PostMapping
    public ResponseEntity<RefundResponse> create(@Validated @RequestBody RefundRequest request) {

        return ResponseEntity.ok(this.refundService.create(request));

    }

    @Override
    @GetMapping(path = "/{id}")
    public ResponseEntity<RefundResponse> read(Long aLong) {
        return ResponseEntity.ok(this.refundService.read(aLong));
    }

    @GetMapping
    // Este codigo tiene la funcionalidad aplicada. para retornar las fechas. con el
    // refundRequestGetAll.
    @Override
    public ResponseEntity<Page<RefundResponse>> getAll(@Validated @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false, value = "") Method method,
            @RequestParam(required = false) Reason reason,
            @RequestParam(required = false, value = "") LocalDate star,
            @RequestParam(required = false, value = "") LocalDate end) {
        LocalDate dLocalDate = LocalDate.now();
        RefundRequestGetAll request = new RefundRequestGetAll();
        request.setPage(page - 1);
        request.setSize(size);
        request.setMethod(method);
        request.setReason(reason);
        request.setDate(star);
        // se valida la entrada de fechas, para que primero si end llega null, lo
        // convierta en star, y luego se valida que si es despues que la fecha actual,
        // se convierte en la fecha actual, y si es antes que star , se convierte en la
        // fecha star.

        if ((star == null) && (end == null)) {

            return ResponseEntity.ok(this.refundService.getAll1(request));
        } else if (star == null) {
            if (end.isAfter(dLocalDate)) {
                request.setDateEnd(dLocalDate);
                request.setDate(dLocalDate);
            } else {
                request.setDate(end);
                request.setDateEnd(end);
                System.out.println(request.getDate());
                System.out.println(request.getDateEnd());
            }
        } else if (end == null) {
            request.setDateEnd(star);
        } else if (end.isAfter(dLocalDate)) {
            request.setDateEnd(dLocalDate);
        } else if (end.isBefore(star)) {
            request.setDateEnd(star);

        } else {
            request.setDateEnd(end);
        }

        return ResponseEntity.ok(this.refundService.getAll1(request));
        // return ResponseEntity.ok(this.refundService.getAll(page-1, size, method,
        // reason, star, end));
    }

    @Override
    public ResponseEntity<Void> delete(Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<RefundResponse> update(RefundRequest request, Long aLong) {
        return null;
    }

}
