package com.riwi.RiwiMarket.infrastructure.services;

import com.riwi.RiwiMarket.api.dtos.requests.PocketRequest;
import com.riwi.RiwiMarket.api.dtos.responses.PocketResponse;
import com.riwi.RiwiMarket.domain.entities.Pocket;
import com.riwi.RiwiMarket.domain.repositories.PocketRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.GenericService;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IPocketService;
import com.riwi.RiwiMarket.infrastructure.helpers.SupportService;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.PocketMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PocketService implements IPocketService {

    @Autowired
    private final PocketRepository pocketRepository;

    @Autowired
    private final SupportService<Pocket> supportService;

    @Autowired
    private final PocketMapper pocketMapper;

    @Override
    public PocketResponse create(PocketRequest request) {
        Pocket pocket = this.pocketMapper.toUserEntity(request);
        return this.pocketMapper.toUserResponse(this.pocketRepository.save(pocket));
    }

    @Override
    public PocketResponse read(Long id) {
        return null;
    }

    @Override
    public PocketResponse update(Long id, PocketRequest request) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }


    @Override
    public List<PocketResponse> getAll() {
        return null;
    }
}
