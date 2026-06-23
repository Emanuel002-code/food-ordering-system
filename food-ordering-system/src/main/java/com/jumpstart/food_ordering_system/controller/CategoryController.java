package com.jumpstart.food_ordering_system.controller;
import com.jumpstart.food_ordering_system.Response.Response;
import com.jumpstart.food_ordering_system.dto.CategoryDto;
import com.jumpstart.food_ordering_system.service.CategoryService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    }
    @GetMapping("/api/categories")
    public ResponseEntity<Response<List<CategoryDto>>> getAllCategories()
    {
        List<CategoryDto> categoryList = categoryService.getAllCategories();

        return ResponseEntity.ok(Response.success("Categories retrieved successfully", categoryList));
    }
    @GetMapping("/api/categories/{id}")
    public ResponseEntity<Response<CategoryDto>> getCategoryById(@PathVariable Long id)
    {
        CategoryDto categoryDto= categoryService.getCategoryById(id);

        return  ResponseEntity.ok(Response.success("Category retrieved successfully", categoryDto));

    }
    @PostMapping("/api/categories" )
    public ResponseEntity<Response<CategoryDto>> addCategory(@Valid @RequestBody CategoryDto dto)
    {
         CategoryDto savedCategory = categoryService.addCategory(dto);

         return ResponseEntity.status(HttpStatus.CREATED).body(Response.success( "Category created successfully",savedCategory));
    }
    @PutMapping("/api/categories/{id}")
    public  ResponseEntity<Response<CategoryDto>> updatedCategory(@PathVariable Long id, @Valid @RequestBody CategoryDto dto)
    {

        CategoryDto updatedCategory = categoryService.updateCategory(id,dto);

        return  ResponseEntity.ok(Response.success( "Category updated successfully",updatedCategory));
    }
    @DeleteMapping("/api/categories/{id}")
    public ResponseEntity<Response<CategoryDto>> deleteCategory(@PathVariable Long id)
    {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok(Response.success( "Category deleted successfully", null));
    }



}
