package com.riwi.RiwiMarket.api.controllers;

import com.riwi.RiwiMarket.api.abstract_controller.GenericController;
import com.riwi.RiwiMarket.api.dtos.requests.ProductRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ProductResponse;
import com.riwi.RiwiMarket.domain.entities.Product;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.supercsv.io.ICsvBeanWriter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/products")
public class ProductController implements GenericController<ProductRequest, ProductResponse,Long> {


    @Autowired
    private final IProductService productService;

    @Override
    @PostMapping
    @Operation(
            summary = "Create Product",
            description = "Fill in the required fields to create a new Product."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid page or size parameters"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    }
    )


    public ResponseEntity<ProductResponse> create(ProductRequest request) {
        return ResponseEntity.ok(this.productService.create(request));
    }

    @Override
    public ResponseEntity<ProductResponse> read(Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<ProductResponse> update(ProductRequest request, Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
   
    @PutMapping("/description/{id}")
    @Operation(
            summary = "Update product description",
            description = "Change the description to update product description."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid page or size parameters"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    public ResponseEntity<ProductResponse> updateProductDescription(@PathVariable Long id, @RequestParam String description) {
        return ResponseEntity.ok(this.productService.updateProductDescription(id,description));
    }

    @Operation(
            summary = "export archive.csv",
            description = "Download a csv format file with product information"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid page or size parameters"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/export-csv")
    public void  exportCsv(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition","attachment: filename=Products" + System.currentTimeMillis()+".csv");
    ICsvBeanWriter writer= this.productService.getCsv(response);
    writer.close();

}
    @Operation(
            summary = "import archive.csv",
            description = "Upload a csv file for reading and creating content"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid page or size parameters"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping(path = "/import-csv",consumes = "multipart/form-data")
    public ResponseEntity<List<ProductResponse>> importCsv(@RequestParam("archivo Csv") MultipartFile  archivoCsv){

        return ResponseEntity.ok(this.productService.setCsv(archivoCsv));
    }
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid page or size parameters"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @Operation(
            summary = "export archive.xlsx",
            description = "Download an Excel file in xlsx format with product information"
    )
    @GetMapping(value = "/export-xlsx",produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    public ResponseEntity<byte[]> getXml() throws IOException{
        ByteArrayInputStream in = this.productService.getXls();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition","attachment; filename=Product.xlsx");
        return  ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_OCTET_STREAM).body(in.readAllBytes());
    }
    @Operation(
            summary = "import archive.xlsx",
            description = "Upload an Excel file in xlsx format for reading and content creation"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid page or size parameters"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping(path = "/import-xlsx",consumes = "multipart/form-data")
    public ResponseEntity<List<ProductResponse>> importXlsx(@RequestParam("archivo Xlsx") MultipartFile  archivoXlsx) throws IOException{

        return ResponseEntity.ok(this.productService.setXlsx(archivoXlsx));
    }
    @PutMapping("/price/{id}")
    @Operation(
            summary = "Update product price",
            description = "add and change the price to product."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid page or size parameters"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    public ResponseEntity<ProductResponse> addProductPrice(@PathVariable Long id, @RequestParam BigDecimal price) {
        return ResponseEntity.ok(this.productService.addProductPrice(id,price));

    }
    @GetMapping("/FindBySubCategory/{id}")
    @Operation(
            summary = "find product by SubCategory",
            description = "Enter the SubCategory ID of the products."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid page or size parameters"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public  ResponseEntity<List<ProductResponse>> FindBySubCategory(@PathVariable Long id){
        return ResponseEntity.ok(this.productService.findBySubcategory(id));
    }
    @GetMapping("/FindByCategory/{id}")
    @Operation(
            summary = "find product by Category",
            description = "Enter the Category ID of the products."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid page or size parameters"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public  ResponseEntity<List<ProductResponse>> FindBySCategory(@PathVariable Long id){
        return ResponseEntity.ok(this.productService.findByCategory(id));
    }
    @GetMapping("/FindByBrand/{id}")
    @Operation(
            summary = "find product by Brand",
            description = "Enter the Brand ID of the products."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid page or size parameters"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public  ResponseEntity<List<ProductResponse>> FindByBrand(@PathVariable Long id){
        return ResponseEntity.ok(this.productService.findByBrand(id));
    }

}