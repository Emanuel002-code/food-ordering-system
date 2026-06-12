package com.jumpstart.food_ordering_system.service;


import com.jumpstart.food_ordering_system.dto.CategoryDto;

import java.util.List;
/*
   Interface for  storing all categories into the list
 */
public interface CategoryService {

    List<CategoryDto> getAllCategories();
}
