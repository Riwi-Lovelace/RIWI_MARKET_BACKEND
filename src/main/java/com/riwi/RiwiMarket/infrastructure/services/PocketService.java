package com.riwi.RiwiMarket.infrastructure.services;

import com.riwi.RiwiMarket.api.dtos.requests.PocketRequest;
import com.riwi.RiwiMarket.api.dtos.responses.PocketResponse;
import com.riwi.RiwiMarket.domain.entities.Pocket;
import com.riwi.RiwiMarket.domain.repositories.PocketRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IPocketService;
import com.riwi.RiwiMarket.infrastructure.helpers.SupportService;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.PocketMapper;
import com.riwi.RiwiMarket.util.enums.TypePocket;
import com.riwi.RiwiMarket.util.exceptions.BadIdException;
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

        if (this.checkingDescriptionExistence(request.getDescription())){
            System.out.println("You can not create a pocket with a same description");
            return null;
        }else {

            if(request.getType().equals(TypePocket.CASH)){

                if (chekingCashExistence()){
                    System.out.println("You already have a Cash pocket, you are only allowed to have one of this type");
                    return null;
                }else {
                    System.out.println("You created a cash pocket");
                    return this.pocketMapper.toUserResponse(this.pocketRepository.save(pocket));
                }

            }else{
                System.out.println("You created a bank pocket");
                return this.pocketMapper.toUserResponse(this.pocketRepository.save(pocket));
            }

        }
    }

    @Override
    public PocketResponse read(Long id) {
        return this.pocketMapper.toUserResponse(this.pocketRepository.findById(id).orElseThrow(() -> new BadIdException("Pocket")));
    }

    @Override
    public PocketResponse update(Long id, PocketRequest request) {
        // buscar el bolsillo a editar
        Pocket pocket = this.supportService.findById(id,"pocket");

        pocket.setAmount(request.getAmount());
        pocket.setType(request.getType());
        pocket.setDescription(request.getDescription());

        return this.pocketMapper.toUserResponse(this.pocketRepository.save(pocket));
    }

    @Override
    public void delete(Long id) {
        this.pocketRepository.delete(this.supportService.findById(id,"pocket"));
    }


    @Override
    public List<PocketResponse> getAll() {
        return this.pocketMapper.listEntitiesToPocketResp(this.pocketRepository.findAll());
    }


    //Checking if description is unique.
    private boolean checkingDescriptionExistence(String description){

        if (this.pocketRepository.findByDescription(description) != null){
            return true;
        }else{
            return false;
        }


    }

    //Checking if cash pocket already exist.
    private boolean chekingCashExistence (){
        List<Pocket> pockets =  this.pocketRepository.findByType(TypePocket.CASH);
        if (pockets.size() == 0){
            return false;
        }else {
            return true;
        }
    }
}
