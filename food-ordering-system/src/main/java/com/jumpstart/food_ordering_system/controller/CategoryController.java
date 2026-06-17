package com.jumpstart.food_ordering_system.controller;
import com.jumpstart.food_ordering_system.dto.CategoryDto;
import com.jumpstart.food_ordering_system.entity.Category;
import com.jumpstart.food_ordering_system.service.CategoryService;
import com.jumpstart.food_ordering_system.service.CategoryServiceImpl;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * REST Controller for category endpoints.
 */
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){

        this.categoryService = categoryService;
    };
    @GetMapping("/api/category")
    public List<CategoryDto> getAllCategories()
    {
        return categoryService.getAllCategories();
    }
    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable Long id)
    {
        return  categoryService.getCategoryById(id);
    }
    @PostMapping
    public ResponseEntity<CategoryDto> addCategory(@Valid @RequestBody CategoryDto dto)
    {
          CategoryDto savedCategory = categoryService.addCategory(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<CategoryDto> updatedCategory(@PathVariable Long id, @Valid @RequestBody CategoryDto dto)
    {

        CategoryDto updatedCategory = categoryService.updateCategory(id,dto);

        return  ResponseEntity.ok(updatedCategory);
    }

}
