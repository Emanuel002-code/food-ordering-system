package com.jumpstart.food_ordering_system.service;

import com.jumpstart.food_ordering_system.dto.CategoryDto;
import com.jumpstart.food_ordering_system.entity.Category;
import com.jumpstart.food_ordering_system.exception.CategoryNotFoundException;
import com.jumpstart.food_ordering_system.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public CategoryDto getCategoryById(Long id) {
       //get the category by id
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        // If the category is not found, create an exception object
        Category category = categoryOptional.orElseThrow(()-> new CategoryNotFoundException("Category with id:"+id+" is not found"));

        //create a categoryDTO object

        return new CategoryDto(category.getId(),category.getName());
    }

    @Override
    public CategoryDto addCategory(CategoryDto dto) {
        //create category from DOT object
       Category category= new Category();
       category.setName(dto.getName());

       //Save to the database
        Category saveCategory = categoryRepository.save(category);

        //Entity to DTO
        return new CategoryDto(saveCategory.getId(), saveCategory.getName());

    }

    @Override
    public CategoryDto updateCategory(Long id,  CategoryDto dto) {
       //get the category by id
        Optional<Category> category = categoryRepository.findById(id);

        //throw the exception if the category is not found
        Category foundCategory = category.orElseThrow(()->new CategoryNotFoundException("Category with id "+id +" not found"));

        //update the category
        foundCategory.setName(dto.getName());
        //save the updated category
        Category updatedCategory= categoryRepository.save(foundCategory);

        //Entity ->DTO
        return  new CategoryDto(updatedCategory.getId(),updatedCategory.getName());

    }

    @Override
    public void deleteCategory(Long id) {

        //get the category by id
        Optional<Category> category = categoryRepository.findById(id);

        //throw the exception if the category is not found
        Category deleteCategory = category.orElseThrow(()->new CategoryNotFoundException("Category with id "+id +" not found"));

        //delete the category
        categoryRepository.delete(deleteCategory);

    }
}
