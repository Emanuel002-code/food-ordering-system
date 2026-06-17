package com.jumpstart.food_ordering_system.controller;
import com.jumpstart.food_ordering_system.dto.CategoryDto;
import com.jumpstart.food_ordering_system.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
