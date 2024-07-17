package com.riwi.RiwiMarket.infrastructure.abstract_services;

import java.math.BigDecimal;

import com.riwi.RiwiMarket.api.dtos.requests.ProductRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ProductResponse;

import java.util.UUID;
import com.riwi.RiwiMarket.domain.entities.Product;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.io.ICsvWriter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

public interface IProductService extends GenericService<ProductRequest, ProductResponse,Long>{
    public void addBrandToProduct(Long productId, Long brandId);
    ProductResponse updateProductDescription(Long id, String description);
    ProductResponse addProductPrice(Long id, BigDecimal price);
    ICsvBeanWriter getCsv(HttpServletResponse response) throws IOException;
    public List<ProductResponse> setCsv(MultipartFile file);
    public ByteArrayInputStream getXls() throws IOException;
    public List<ProductResponse> setXlsx(MultipartFile archive)  throws IOException;
}
