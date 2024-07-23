package com.riwi.RiwiMarket.infrastructure.services;

import com.riwi.RiwiMarket.api.dtos.requests.StockQuantityUpdateRequest;
import com.riwi.RiwiMarket.api.dtos.requests.StockRequest;
import com.riwi.RiwiMarket.api.dtos.requests.StockWeightUpdateRequest;
import com.riwi.RiwiMarket.api.dtos.responses.StockResponse;
import com.riwi.RiwiMarket.domain.entities.Batch;
import com.riwi.RiwiMarket.domain.entities.Stock;
import com.riwi.RiwiMarket.domain.repositories.BatchRepository;
import com.riwi.RiwiMarket.domain.repositories.StockRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IStockService;
import com.riwi.RiwiMarket.infrastructure.helpers.SupportService;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.StockMapper;
import com.riwi.RiwiMarket.util.enums.GeneralSort;
import com.riwi.RiwiMarket.util.exceptions.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    @Autowired
    private final BatchRepository batchRepository;

    @Autowired
    private final SupportService<Batch> supportServiceBatch;

    @Override
    public StockResponse create(StockRequest request) {

        Batch batch = this.supportServiceBatch.findById(batchRepository, request.getBatch_id(), "batch");

        Stock stock = new Stock();
        //validate that the batch it is not associated to a stock
        if(this.stockRepository.findByBatch(batch) != null){
            throw new BadRequestException("This batch is associated to a stock. A batch only can have a stock associated");
        }
        stock.setBatch(batch);

        if (batch.getQuantity() != null){
            stock.setQuantity(batch.getQuantity());
            stock.setWeight(null);
        }else {
            stock.setWeight(batch.getWeight());
            stock.setQuantity(null);
        }

        Stock savedStock = stockRepository.save(stock);
        return stockMapper.toResponse(savedStock);
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

        PageRequest pageRequest = null;
        switch (generalSort) {
            case NONE -> pageRequest = PageRequest.of(page-1, size);
            case ASC -> pageRequest = PageRequest.of(page-1, size, Sort.by(FIELD_BY_SORT_STOCK).ascending());
            case DESC -> pageRequest = PageRequest.of(page-1, size, Sort.by(FIELD_BY_SORT_STOCK).descending());
        }


        if(productName == null && categoryName == null){
            //if user doesn't input productName and categoryName
            Page<Stock> stockPage = this.stockRepository.findAll(pageRequest);

            //Create paginate
            List<StockResponse> stockResponse = this.stockMapper.listEntitiesToStockResp(stockPage.getContent());
            return new PageImpl<>(stockResponse, pageRequest, stockPage.getTotalElements());

        }else {
            //Use the advance Query getall
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
