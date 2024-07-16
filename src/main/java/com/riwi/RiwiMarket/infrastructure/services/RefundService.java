package com.riwi.RiwiMarket.infrastructure.services;

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
import com.riwi.RiwiMarket.util.enums.Method;
import com.riwi.RiwiMarket.util.enums.Reason;
import com.riwi.RiwiMarket.util.exceptions.BadRequestException;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

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
        return null;
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

    @Override
    public Page<RefundResponse> findByMethodContainingAndReasonContainingAndDateContaining(int page, int size, java.lang.String method, java.lang.String reason, java.time.LocalDateTime date) {

        /*PageRequest pageRequest = PageRequest.of(page, size);*/

      /*  if (method.isEmpty() && reason.isEmpty()){
            return refundRepository.findAll(pageRequest);
        }

        Enumcito enume;
        try {
            enume = Enumcito.valueOf(enum2);
        } catch (IllegalArgumentException e) {
            return repo2.findByEnum2OrAttribute(null, attribute,pageRequest);
        }

        if (!attribute.isEmpty() && !enum2.isEmpty()) {
            return repo2.findByEnum2AndAttribute(enume, attribute,pageRequest);
        } else {
            return repo2.findByEnum2OrAttribute(enume, attribute,pageRequest);
        }
    }*/
        return  null;
    }
}
