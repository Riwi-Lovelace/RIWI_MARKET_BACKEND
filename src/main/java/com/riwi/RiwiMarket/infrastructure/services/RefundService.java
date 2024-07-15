package com.riwi.RiwiMarket.infrastructure.services;

import com.riwi.RiwiMarket.api.dtos.requests.RefundRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ItemResponse;
import com.riwi.RiwiMarket.api.dtos.responses.RefundResponse;
import com.riwi.RiwiMarket.domain.entities.Item;
import com.riwi.RiwiMarket.domain.entities.Refund;
import com.riwi.RiwiMarket.domain.repositories.ItemRepository;
import com.riwi.RiwiMarket.domain.repositories.RefundRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IRefundService;
import com.riwi.RiwiMarket.infrastructure.helpers.SupportService;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.ItemMapper;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.RefundMapper;
import com.riwi.RiwiMarket.util.enums.Method;
import com.riwi.RiwiMarket.util.enums.Reason;
import com.riwi.RiwiMarket.util.exceptions.BadRequestException;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class RefundService implements IRefundService {

    @Autowired
    RefundMapper returnMapper;

    @Autowired
<<<<<<< HEAD
    private final RefundRepository refundRepository;
=======
    RefundRepository refundRepository;
    @Autowired
    ItemRepository itemRepository;
>>>>>>> 934abf820dd77b06e2058fbc2c8d3303f78d838f

    @Autowired
    SupportService<Refund> supportService;
    @Autowired
    ItemMapper itemMapper;

    @Override
    public RefundResponse create(RefundRequest request) {
        Refund refund = this.returnMapper.toEntity(request);
        Item item = itemRepository.findById(request.getItemId())
                .orElseThrow(() -> new BadRequestException("ID NOT FOUND"));
        
        refund.setItemId(item);
        int valor=(item.getQuantity() - request.getQuantity()) ;
        if (valor==0) {
            item.setStatus(false);
            item.setQuantity(valor);

        }else{
                item.setQuantity(valor);

        }

        itemRepository.save(item);
        return returnMapper.toResponse(refundRepository.save(refund));
    }

    @Override
    public Page<RefundResponse> getAll(int page, int size) {
        if (page < 0) page = 0;

        PageRequest paginable = PageRequest.of(page, size);

        return this.refundRepository.findAll(paginable).map(this.returnMapper::entityToResponse);
    }

    @Override
    public List<Refund> findByMethod(Method method) {
        return null;
    }

    @Override
    public List<Refund> findByReason(Reason reason) {
        return null;
    }

    @Override
    public RefundResponse read(Long aLong) {
        return null;
    }

    @Override
    public List<Refund> findByDate(LocalDate startDate, LocalDate endDate) {
        return null;
    }

    @Override
    public RefundResponse update(Long aLong, RefundRequest request) {
        // Not contemplated
        return null;
    }

    @Override
    public void delete(Long aLong) {
        // Not contemplated
    }


    public Refund find(Long id){
        return this.refundRepository.findById(id).orElseThrow();
    }

    @Override
    public RefundResponse getById(Long id){
        return this.returnMapper.entityToResponse(this.find(id));
    }
}
