package com.example.JobPortal.service.impl;

import com.example.JobPortal.model.Category;
import com.example.JobPortal.model.dto.CategoryDto;
import com.example.JobPortal.model.enums.Industry;
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
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> findAllCategoriesByIndustry(String industry) {
        return categoryRepository.findAllCategoriesByIndustry(industry);
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

        Industry industry = Industry.valueOf(categoryDto.getMainCategory());
        category.setIndustry(industry);
    }
}
