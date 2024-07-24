package com.riwi.RiwiMarket.infrastructure.services;

import com.riwi.RiwiMarket.api.dtos.requests.StockRequest;
import com.riwi.RiwiMarket.api.dtos.requests.StockUpdateRequest;
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

import java.math.BigDecimal;
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
    public StockResponse updateStock(StockUpdateRequest request, Long id) {
        Stock stock = this.supportService.findById(this.stockRepository, id, "Stock");

        if (request.getQuantity() < 0 || request.getWeight().compareTo(BigDecimal.ZERO) < 0) {

            throw new BadRequestException("Negative values are not valid");

        } else if (request.getQuantity() == 0 && request.getWeight().compareTo(BigDecimal.ZERO) == 0) {

            if (checkIfIsQuantity(stock)) {
                stock.setQuantity(0);
            }else{
                stock.setWeight(BigDecimal.ZERO);
            }
            this.stockRepository.save(stock);

        } else if (request.getQuantity() != 0 && !request.getWeight().equals(BigDecimal.ZERO)) {

            throw new BadRequestException("You can only update one field. Quantity or weight. But not both.");

        } else {
            if (request.getQuantity() != 0) {
                if (checkIfIsQuantity(stock)) {
                    stock.setQuantity(request.getQuantity());
                    stock.setWeight(null);
                    this.stockRepository.save(stock);
                } else {
                    throw new BadRequestException("You can not update quantity, cause this product is measured in weight");
                }
            } else {
                if (!checkIfIsQuantity(stock)) {
                    stock.setWeight(request.getWeight());
                    stock.setQuantity(null);
                    this.stockRepository.save(stock);
                } else {
                    throw new BadRequestException("You can not update weight, cause this product is measured in quantity");
                }
            }
        }
        return stockMapper.toResponse(stock);
    }

    private boolean checkIfIsQuantity(Stock stock) {
        if (stock.getQuantity() != null && stock.getWeight() == null) {
            return true;
        } else {
            return false;
        }
    }
}
