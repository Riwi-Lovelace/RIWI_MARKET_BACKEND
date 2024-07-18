package com.riwi.RiwiMarket.infrastructure.services;
import com.riwi.RiwiMarket.util.enums.Method;
import com.riwi.RiwiMarket.util.enums.Reason;
import com.riwi.RiwiMarket.api.dtos.requests.RefundRequest;
import com.riwi.RiwiMarket.api.dtos.responses.RefundResponse;
import com.riwi.RiwiMarket.domain.entities.Item;
import com.riwi.RiwiMarket.domain.entities.Refund;
import com.riwi.RiwiMarket.domain.repositories.ItemRepository;
import com.riwi.RiwiMarket.domain.repositories.RefundRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IRefundService;
import com.riwi.RiwiMarket.infrastructure.helpers.SupportService;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.ItemMapper;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.RefundMapper;
import com.riwi.RiwiMarket.util.exceptions.BadRequestException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class RefundService implements IRefundService {

    @Autowired
    RefundMapper returnMapper;

    @Autowired
    RefundRepository refundRepository;
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    SupportService<Refund> supportService;
    @Autowired
    ItemMapper itemMapper;

    @Override
    public RefundResponse create(RefundRequest request) {
        Refund refund = this.returnMapper.toEntity(request);
        refund.setDate(LocalDate.now());
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
        //Get prueba

        itemRepository.save(item);
        return returnMapper.toResponse(refundRepository.save(refund));
    }
 


    @Override
    public Page<RefundResponse> getAll(int page, int size, Method method,Reason reason, LocalDate date,
            LocalDate dateEnd) {
                PageRequest pageRequest = PageRequest.of(page, size);
                if(reason == null && method == null && dateEnd == null && date == null){
                    Page<Refund> refundPage = this.refundRepository.findAll(pageRequest);
                    List<RefundResponse> refundResponse =this.returnMapper.RefundListToResponseList(refundPage.getContent());
                    return new PageImpl<>(refundResponse, pageRequest,refundPage.getTotalElements());
                }else{
                    // Page<Refund> refundPage = this.refundRepository.findByMethodOrReasonOrDateBetween(method, reason, pageRequest,date,dateEnd);
                   Page<Refund> refundPage = this.refundRepository.getall(pageRequest,method,reason,date,dateEnd);
                    List<RefundResponse> refundResponse =this.returnMapper.RefundListToResponseList(refundPage.getContent());
                    return new PageImpl<>(refundResponse, pageRequest,refundPage.getTotalElements());
                }
    }
    @Override
    public RefundResponse read(Long aLong) {
        Refund refund = this.supportService.findById(refundRepository, aLong, "Refund");
        return this.returnMapper.toResponse(refund);
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

}
