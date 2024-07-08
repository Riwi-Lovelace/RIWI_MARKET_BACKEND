package com.riwi.RiwiMarket.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.riwi.RiwiMarket.api.abstract_controller.GenericController;
import com.riwi.RiwiMarket.api.dtos.requests.SubCategoryPatchRequest;
import com.riwi.RiwiMarket.api.dtos.requests.SubcategoryRequest;
import com.riwi.RiwiMarket.api.dtos.responses.SubcategoryResponse;
import com.riwi.RiwiMarket.infrastructure.abstract_services.ISubcategory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/subcategory")
@AllArgsConstructor
@Tag(name = "Subcategory Endpoints")
public class SubcategoryController implements GenericController<SubcategoryRequest, SubcategoryResponse, Long>{
    @Autowired
    private final ISubcategory subcategoryService;


    @Override
    @Operation(summary = "Create a Subcategory", description = "Create a Subcategory depending a category, first, you need to create a category.")
    @ApiResponses(
        value = {
                @ApiResponse(responseCode = "200", description = "Subcategory was created", content = {
                    @Content(mediaType = "application/json")
                }),
                @ApiResponse(responseCode = "400", description = "Error request")
                }
    )
    @PostMapping("/create")
    public ResponseEntity<SubcategoryResponse> create(SubcategoryRequest request) {
        return ResponseEntity.ok(this.subcategoryService.create(request));
    }
    @Operation(summary = "Get All the Subcategories", description = "get all the Subcategories that were created, just you need put a number pages and number size what you want")
    @ApiResponses(
        value = {
                @ApiResponse(responseCode = "200", description = "All the subcategories were obtained", content = {
                    @Content(mediaType = "application/json")
                }),
                @ApiResponse(responseCode = "400", description = "Error request")
                }
    )
    @GetMapping("/getAll")
    public ResponseEntity<Page<SubcategoryResponse>> getAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size){
        return ResponseEntity.ok(this.subcategoryService.getAll(page - 1, size));
    }

    @Override
    @ApiResponse(responseCode = "400", description = "When the id is not valid.", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @Operation(summary = "List a subcategory by the specific id.", description = "You must send the id of the subcategory you want to list.")
    @GetMapping(path = "/{id}/getById")
    public ResponseEntity<SubcategoryResponse> read(@PathVariable Long id) {
        return ResponseEntity.ok(this.subcategoryService.read(id));
    }

    @Override
    @ApiResponse(responseCode = "400", description = "When the id is not valid.", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @Operation(summary = "Update a subcategory.", description = "You must enter the name, status, category id.")
    @PutMapping("/{id}")
    public ResponseEntity<SubcategoryResponse> update(@Validated @RequestBody SubcategoryRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(this.subcategoryService.update(id, request));
    }
    @ApiResponse(responseCode = "400", description = "When the id is not valid.", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @Operation(summary = "Update a name.", description = "You must enter the name to modify.")
    @PatchMapping("/{id}/name")
    public ResponseEntity<SubcategoryResponse> patchName(@Validated @RequestBody SubCategoryPatchRequest request, @PathVariable Long id) {
        SubcategoryResponse subCategoryPatchRequest = this.subcategoryService.patchName(id, request);
        return ResponseEntity.ok(subCategoryPatchRequest);
    }

    @ApiResponse(responseCode = "400", description = "When the id is not valid.", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @Operation(summary = "Update a status.", description = "You must enter the status to modify.")
    @PatchMapping("/{id}/status")
    public ResponseEntity<SubcategoryResponse> patchStatus(@Validated @RequestBody SubCategoryPatchRequest request, @PathVariable Long id) {
        SubcategoryResponse subCategoryPatchRequest = this.subcategoryService.patchStatus(request, id);
        return ResponseEntity.ok(subCategoryPatchRequest);
    }
    

    @Override
    public ResponseEntity<Void> delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
