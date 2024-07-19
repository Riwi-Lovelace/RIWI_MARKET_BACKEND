package com.riwi.RiwiMarket.infrastructure.services;

import com.riwi.RiwiMarket.api.dtos.requests.StockQuantityUpdateRequest;
import com.riwi.RiwiMarket.api.dtos.requests.StockRequest;
import com.riwi.RiwiMarket.api.dtos.requests.StockWeightUpdateRequest;
import com.riwi.RiwiMarket.api.dtos.responses.StockResponse;
import com.riwi.RiwiMarket.domain.entities.Stock;
import com.riwi.RiwiMarket.domain.repositories.StockRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IStockService;
import com.riwi.RiwiMarket.infrastructure.helpers.SupportService;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.StockMapper;
import com.riwi.RiwiMarket.util.enums.GeneralSort;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class StockService implements IStockService {

    @Autowired
    private final StockRepository stockRepository;

    @Autowired
    private final SupportService<Stock> supportService;

    @Autowired
    private final StockMapper stockMapper;
    @Override
    public StockResponse create(StockRequest request) {
        return null;
    }

    @Override
    public StockResponse read(Long id) {
        return null;
    }

    @Override
    public StockResponse update(Long id, StockRequest request) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Page<StockResponse> getAll(String productName, String categoryName, int size, int page, GeneralSort generalSort) {
        PageRequest pageRequest = PageRequest.of(page-1,size);

        if(productName == null && categoryName == null){
            System.out.println("entro a findAll");
            Page<Stock> stockPage = this.stockRepository.findAll(pageRequest);
            List<Stock> stocks = this.stockRepository.findAll();
            for(Stock stock: stocks){
                System.out.println("id: " + stock.getId());
                System.out.println("quantity " + stock.getQuantity());
                System.out.println("weight " + stock.getWeight());
            }

            System.out.println("Esto es paginate");

            for(Stock stocke: stockPage.getContent()){
                System.out.println("id: " + stocke.getId());
                System.out.println("quantity " + stocke.getQuantity());
                System.out.println("weight " + stocke.getWeight());
            }


            List<StockResponse> stockResponse = this.stockMapper.listEntitiesToStockResp(stockPage.getContent());
            return new PageImpl<>(stockResponse, pageRequest, stockPage.getTotalElements());
        }else {
            Page<Stock> stockPage = this.stockRepository.getall(pageRequest,productName,categoryName);
            List<StockResponse> stockResponse = this.stockMapper.listEntitiesToStockResp(stockPage.getContent());
            return new PageImpl<>(stockResponse , pageRequest,stockPage.getTotalElements());
        }



    }

    @Override
    public StockResponse updateQuantity(StockQuantityUpdateRequest request, Long id) {
        return null;
    }

    @Override
    public StockResponse updateWeight(StockWeightUpdateRequest request, Long id) {
        return null;
    }
}
