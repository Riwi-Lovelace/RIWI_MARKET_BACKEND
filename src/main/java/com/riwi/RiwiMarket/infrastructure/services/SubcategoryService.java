package com.riwi.RiwiMarket.infrastructure.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.RiwiMarket.api.dtos.requests.SubCategoryPatchRequest;
import com.riwi.RiwiMarket.api.dtos.requests.SubcategoryRequest;
import com.riwi.RiwiMarket.api.dtos.responses.SubcategoryResponse;
import com.riwi.RiwiMarket.domain.entities.Category;
import com.riwi.RiwiMarket.domain.entities.Subcategory;
import com.riwi.RiwiMarket.domain.repositories.CategoryRepository;
import com.riwi.RiwiMarket.domain.repositories.SubcategoryRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.ISubcategory;
import com.riwi.RiwiMarket.infrastructure.helpers.SupportService;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.SubcategoryMapper;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class SubcategoryService implements ISubcategory  {
    @Autowired
    private final SubcategoryMapper subcategoryMapper;
    
    @Autowired
    private final SubcategoryRepository subcategoryRepository;

    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    private final SupportService<Subcategory> supportService;

    @Autowired
    private final SupportService<Category> supportServiceCategory;
    
    
    @Override
    public SubcategoryResponse create(SubcategoryRequest request) {
        Subcategory subcategory = this.subcategoryMapper.toEntity(request);
        Category category = this.supportServiceCategory.findById(categoryRepository, request.getCategoryId(), "Category");
        subcategory.setCategory(category);
        subcategory.setStatus(true);
        return subcategoryMapper.toResponse(this.subcategoryRepository.save(subcategory));
    }

    @Override
    public Page<SubcategoryResponse> getAll(int page, int size){
        if (page < 0) page = 0;
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Subcategory> subCategoryPage = this.subcategoryRepository.findAll(pageRequest);
        Page<SubcategoryResponse> SubCategoryResponsePage =  subcategoryMapper.subCategoryResponsePage(subCategoryPage, page, size);
        return SubCategoryResponsePage;
    }

    @Override
    public SubcategoryResponse read(Long id) {
        return subcategoryMapper.toSubcategoryResponse(this.supportService.findById(subcategoryRepository, id, "SubCategory"));
    }

    @Override
    public SubcategoryResponse update(Long id, SubcategoryRequest request) {
        Subcategory subcategoryObj = this.supportService.findById(subcategoryRepository,id,"SubCategory");
        Subcategory subcategory = (Subcategory) subcategoryObj;
        subcategoryMapper.toEntity(request);
        return subcategoryMapper.toResponse(this.subcategoryRepository.save(subcategory));
    }
    @Override   
    public SubcategoryResponse patchName(Long id, SubCategoryPatchRequest request){
        Subcategory subcategoryObj = this.supportService.findById(subcategoryRepository,id,"SubCategory");
        Optional<Subcategory> subcategoryOpt = Optional.ofNullable((Subcategory) subcategoryObj);
        Subcategory subcategory = subcategoryOpt.get();
        if (subcategoryOpt.isPresent()) {
            subcategory.setName(request.getName());
        }
        return subcategoryMapper.toResponse(this.subcategoryRepository.save(subcategory));
    }
    
    @Override
    public SubcategoryResponse patchStatus(SubCategoryPatchRequest request, Long id) {
        Object subcategoryObj = this.subcategoryRepository.findById(id).orElseThrow();
        Optional<Subcategory> subcategoryOpt = Optional.ofNullable((Subcategory) subcategoryObj);
        Subcategory subcategory = subcategoryOpt.get();
        if (subcategoryOpt.isPresent()) {
            subcategory.setStatus(request.getStatus());
        }
        return subcategoryMapper.toResponse(this.subcategoryRepository.save(subcategory));
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
