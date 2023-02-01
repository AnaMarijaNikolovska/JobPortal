package com.example.JobPortal.controller;

import com.example.JobPortal.model.Category;
import com.example.JobPortal.model.dto.CategoryDto;
import com.example.JobPortal.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> allCategory() {
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public Optional<Category> oneCategory(@PathVariable Long id) {
        return categoryService.getOneCategory(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }

    @PostMapping
    public Category addCategory(@RequestBody @Valid CategoryDto category) {
        return categoryService.saveCategory(category);
    }

    @PutMapping("/{id}")
    public Category editCategory(@RequestBody @Valid CategoryDto categoryDto, @PathVariable Long id) {
        return categoryService.editCategory(id,categoryDto);
    }

    @GetMapping("/main/{mainCategory}")
    public List<Category> getAllCategoriesByMainCategory(@PathVariable String mainCategory) {
        return categoryService.getAllByMainCategory(mainCategory);
    }
}
