package com.riwi.RiwiMarket.infrastructure.services;

import com.riwi.RiwiMarket.api.dtos.requests.ItemRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ItemResponse;
import com.riwi.RiwiMarket.domain.entities.Item;
import com.riwi.RiwiMarket.domain.entities.Product;
import com.riwi.RiwiMarket.domain.entities.Sale;
import com.riwi.RiwiMarket.domain.repositories.ItemRepository;
import com.riwi.RiwiMarket.domain.repositories.ProductRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IItemService;
import com.riwi.RiwiMarket.infrastructure.helpers.SupportService;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.ItemMapper;
import com.riwi.RiwiMarket.util.exceptions.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class ItemService implements IItemService {
    @Autowired
    private final ItemMapper itemMapper;
    @Autowired
    private final ItemRepository itemRepository;
    @Autowired
    private final SupportService<Product> supportProduct;
    //@Autowired
    //private final SupportService<Sale> supportSale;
    @Autowired
    private  final ProductRepository productRepository;

    @Override
    public ItemResponse create(ItemRequest request) {
    Item item = this.itemMapper.toEntity(request);
    item.setStatus(true);
    Product product =this.supportProduct.findById(productRepository,request.getProductId(),"product");
    //Sale sale =
        item.setProduct(product);
        if (request.getWeight().compareTo(BigDecimal.ZERO)!=0 && request.getQuantity() !=0 ){
            throw new BadRequestException("A product cannot have quantity and weight, only one is allowed.");
        }else {

            if (request.getWeight().compareTo(BigDecimal.ZERO) != 0) {
                System.out.println("calculo por peso");
                item.setTotalPrice(product.getPrice().multiply(request.getWeight()));
                System.out.println(product.getPrice().multiply(request.getWeight()));
            } else {
                System.out.println("calculo por cantidad");
                item.setTotalPrice(product.getPrice().multiply(new BigDecimal(request.getQuantity())));
            }
        }
    return this.itemMapper.toResponse(this.itemRepository.save(item));

    }

    @Override
    public ItemResponse read(Long aLong) {
        return null;
    }

    @Override
    public ItemResponse update(Long aLong, ItemRequest request) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
