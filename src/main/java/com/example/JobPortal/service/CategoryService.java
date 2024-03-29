package com.example.JobPortal.service;

import com.example.JobPortal.model.Category;
import com.example.JobPortal.model.dto.CategoryDto;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getAllCategories();

    List<Category> findAllCategoriesByIndustry(String industry);

    Optional<Category> getOneCategory(Long id);

    Category saveCategory(CategoryDto categoryDto);

    Category editCategory(Long id, CategoryDto categoryDto);

    void deleteCategory(Long id);
}
