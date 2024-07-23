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
import com.riwi.RiwiMarket.util.exceptions.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<StockResponse> getAll(String productName, String categoryName) {
        return null;
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
