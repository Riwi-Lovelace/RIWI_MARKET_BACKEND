package com.riwi.RiwiMarket.infrastructure.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.RiwiMarket.api.dtos.requests.SubCategoryPatchRequest;
import com.riwi.RiwiMarket.api.dtos.requests.SubcategoryRequest;
import com.riwi.RiwiMarket.api.dtos.responses.SubcategoryResponse;
import com.riwi.RiwiMarket.domain.entities.Subcategory;
import com.riwi.RiwiMarket.domain.repositories.SubcategoryRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.ISubcategory;
import com.riwi.RiwiMarket.infrastructure.helpers.SupportService;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.SubcategoryMapper;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class SubcategoryService implements ISubcategory  {
    @Autowired
    private final SupportService supportService;
    @Autowired
    private final SubcategoryRepository subcategoryRepository;

    @Override
    public SubcategoryResponse create(SubcategoryRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public SubcategoryResponse read(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public SubcategoryResponse update(Long id, SubcategoryRequest request) {
        Object subcategoryObj = this.supportService.findById(id, "The subcategory id not found");
        Subcategory subcategory = (Subcategory) subcategoryObj;
        SubcategoryMapper.mapper.updateSubcategoryFromDto(request, subcategory);
        return SubcategoryMapper.mapper.toUserResponse(this.subcategoryRepository.save(subcategory));
    }
       
    public SubcategoryResponse patch(Long id, SubCategoryPatchRequest request){
        Object subcategoryObj = this.supportService.findById(id, "The subcategory id not found");
        System.out.println(subcategoryObj);
        Subcategory subcategory = (Subcategory) subcategoryObj;
        SubcategoryMapper.mapper.patchSubcategoryFromDto(request, subcategory);
        return SubcategoryMapper.mapper.toUserResponse(this.subcategoryRepository.save(subcategory));
    }
    
    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
