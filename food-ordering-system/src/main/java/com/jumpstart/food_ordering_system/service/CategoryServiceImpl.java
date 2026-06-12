package com.jumpstart.food_ordering_system.service;

import com.jumpstart.food_ordering_system.dto.CategoryDto;
import com.jumpstart.food_ordering_system.entity.Category;
import com.jumpstart.food_ordering_system.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
  Implements the CategoryService Interface by mapping the categories and categoryDTO
 */
@Service
public class CategoryServiceImpl  implements  CategoryService{


    private  final CategoryRepository categoryRepository;

    //create a contructor
    public CategoryServiceImpl(CategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }

  //maps the categories and categoryDTO
    @Override
    public List<CategoryDto> getAllCategories()
    {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryList= new ArrayList<>();

        //create categoryDto object from each caregory
        for(Category category: categories)
        {
            CategoryDto dto = new CategoryDto();
            dto.setId(category.getId());
            dto.setName(category.getName());

            categoryList.add(dto);
        }
        return categoryList;
    }
}
