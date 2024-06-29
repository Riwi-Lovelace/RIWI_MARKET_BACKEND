package com.riwi.RiwiMarket.infrastructure.services;

import com.riwi.RiwiMarket.api.dtos.requests.CategoryRequest;
import com.riwi.RiwiMarket.api.dtos.responses.CategoryResponse;
import com.riwi.RiwiMarket.domain.entities.Category;
import com.riwi.RiwiMarket.domain.repositories.CategoryRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.ICategoryService;
import com.riwi.RiwiMarket.infrastructure.helpers.SupportService;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.CategoryMapper;
import com.riwi.RiwiMarket.util.exceptions.BadIdException;
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
    private final SupportService supportService;



    @Override
    public CategoryResponse create(CategoryRequest request) {
        Category category=this.categoryMapper.toCategoryEntity(request);
        return this.categoryMapper.toCategoryResponse(this.categoryRepository.save(category));
    }

    @Override
    public CategoryResponse read(Long id) {
        return this.categoryMapper.toCategoryResponse((Category) this.supportService.findById(id, "Category"));
    }

    @Override
    public CategoryResponse update(Long aLong, CategoryRequest request) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

}
