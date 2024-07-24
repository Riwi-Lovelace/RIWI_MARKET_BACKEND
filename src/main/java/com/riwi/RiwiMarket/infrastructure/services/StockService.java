package com.riwi.RiwiMarket.infrastructure.services;

import com.riwi.RiwiMarket.api.dtos.requests.StockRequest;
import com.riwi.RiwiMarket.api.dtos.requests.StockUpdateRequest;
import com.riwi.RiwiMarket.api.dtos.responses.StockResponse;
import com.riwi.RiwiMarket.domain.entities.Stock;
import com.riwi.RiwiMarket.domain.repositories.StockRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IStockService;
import com.riwi.RiwiMarket.infrastructure.helpers.SupportService;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.StockMapper;
import com.riwi.RiwiMarket.util.exceptions.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<StockResponse> getAll(String productName, String categoryName) {
        return null;
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
