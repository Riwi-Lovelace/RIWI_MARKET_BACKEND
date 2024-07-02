package com.riwi.RiwiMarket.infrastructure.services;

import com.riwi.RiwiMarket.api.dtos.requests.CategoryRequest;
import com.riwi.RiwiMarket.api.dtos.responses.CategoryResponse;
import com.riwi.RiwiMarket.domain.entities.Category;
import com.riwi.RiwiMarket.domain.repositories.CategoryRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.ICategoryService;
import com.riwi.RiwiMarket.infrastructure.helpers.SupportService;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.CategoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService implements ICategoryService {

    @Autowired
    private final CategoryRepository  categoryRepository;
    @Autowired
    private final CategoryMapper categoryMapper;
    @Autowired
    private final SupportService<Category> supportService;

    @Override
    public CategoryResponse create(CategoryRequest request) {
        Category category=this.categoryMapper.toEntity(request);
        return this.categoryMapper.toResponse(this.categoryRepository.save(category));
    }

    @Override
    public CategoryResponse read(Long id) {
        return this.categoryMapper.toResponse((Category)  this.supportService.findById(categoryRepository, id, "Category"));
    }

    @Override
    public CategoryResponse update(Long aLong, CategoryRequest request) {
        Category entity =  this.supportService.findById(categoryRepository, aLong, "Category");
        if (!request.getName().equals("string")) {
            entity.setName(request.getName());
        }
        if (request.isStatus()!= entity.getStatus()){
            entity.setStatus(request.isStatus());
        }
        return this.categoryMapper.toResponse(this.categoryRepository.save(entity));

    }


    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Page<CategoryResponse> getAll(int page, int size) {
        if (page < 0){
            page = 0;
        }

        PageRequest pagination = PageRequest.of(page, size);
        return this.categoryRepository.findAll(pagination).map(this.categoryMapper::toResponse);
    }


}
