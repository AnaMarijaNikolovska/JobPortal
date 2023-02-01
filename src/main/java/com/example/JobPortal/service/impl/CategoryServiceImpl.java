package com.example.JobPortal.service.impl;

import com.example.JobPortal.model.Account;
import com.example.JobPortal.model.Category;
import com.example.JobPortal.model.dto.AccountDto;
import com.example.JobPortal.model.dto.CategoryDto;
import com.example.JobPortal.model.enums.MainCategory;
import com.example.JobPortal.repository.CategoryRepository;
import com.example.JobPortal.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> getAllByMainCategory(String mainCategory) {
        return categoryRepository.findAllByMainCategory(mainCategory);
    }

    @Override
    public Optional<Category> getOneCategory(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category saveCategory(CategoryDto categoryDto){
        Category category = new Category();
        mapDtoToEntity(category, categoryDto);

        return categoryRepository.save(category);
    }

    @Override
    public Category editCategory(Long id, CategoryDto categoryDto) {
        Optional<Category> optionalCategory = getOneCategory(id);

        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            mapDtoToEntity(category, categoryDto);

            return categoryRepository.save(category);
        }
        return null;
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    private void mapDtoToEntity(Category category, CategoryDto categoryDto) {
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());

        MainCategory mainCategory = MainCategory.valueOf(categoryDto.getMainCategory());
        category.setMainCategory(mainCategory);
    }
}
