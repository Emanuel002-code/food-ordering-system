package com.jumpstart.food_ordering_system.service;


import com.jumpstart.food_ordering_system.dto.CategoryDto;

import java.util.List;
/*
   Interface for  storing all categories into the list
 */
public interface CategoryService {

    /*
     * get all categories
     * @return list of categories
     */
    List<CategoryDto> getAllCategories();

    /*
     *Retrieve the category by id
     * @param id
     * @return CategoryDTO
     */
    CategoryDto getCategoryById(Long id);

    /*
     * Add category
     * @param dto (category)
     * @return CategoryDTO
     */
    CategoryDto addCategory(CategoryDto dto);

    /*
     * update the category
     * @param id, dto (category)
     * @return CategoryDTO
     */
    CategoryDto updateCategory(Long id,  CategoryDto dto);

    /*
     *Remove the category
     * @param id
     */
    void  deleteCategory(Long id);
}
