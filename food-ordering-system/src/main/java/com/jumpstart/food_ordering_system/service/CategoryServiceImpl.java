package com.jumpstart.food_ordering_system.service;

import com.jumpstart.food_ordering_system.dto.CategoryDto;
import com.jumpstart.food_ordering_system.entity.Category;
import com.jumpstart.food_ordering_system.exception.CategoryHasMenusException;
import com.jumpstart.food_ordering_system.exception.CategoryNotFoundException;
import com.jumpstart.food_ordering_system.repository.CategoryRepository;
import com.jumpstart.food_ordering_system.repository.MenuRepository;
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
    private  final MenuRepository menuRepository;

    //create a constructor using Dependency Injection Design pattern
    public CategoryServiceImpl(CategoryRepository categoryRepository, MenuRepository menuRepository)
    {
        this.categoryRepository = categoryRepository;
        this.menuRepository = menuRepository;

    }

  //maps the categories and categoryDTO
    @Override
    public List<CategoryDto> getAllCategories()
    {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryList= new ArrayList<>();

        //create categoryDto object from each category
        for(Category category: categories)
        {
            CategoryDto dto = new CategoryDto();
            dto.setId(category.getId());
            dto.setName(category.getName());
            dto.setDescription(category.getDescription());

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

        return new CategoryDto(category.getId(),category.getName(), category.getDescription());
    }

    @Override
    public CategoryDto addCategory(CategoryDto dto) {
        //create category from DOT object
       Category category= new Category();
       category.setName(dto.getName());
       category.setDescription(dto.getDescription());

       //Save to the database
        Category saveCategory = categoryRepository.save(category);

        //Entity to DTO
        return new CategoryDto(saveCategory.getId(), saveCategory.getName(), saveCategory.getDescription());

    }

    @Override
    public CategoryDto updateCategory(Long id,  CategoryDto dto) {
       //get the category by id
        Optional<Category> category = categoryRepository.findById(id);

        //throw the exception if the category is not found
        Category foundCategory = category.orElseThrow(()->new CategoryNotFoundException("Category with id "+id +" not found"));

        //update the category

        foundCategory.setName(dto.getName());

        if (dto.getDescription() != null)
        { foundCategory.setDescription(dto.getDescription()); };

        //save the updated category
        Category updatedCategory= categoryRepository.save(foundCategory);

        //Entity ->DTO
        return  new CategoryDto(updatedCategory.getId(),updatedCategory.getName(), updatedCategory.getDescription());

    }

    @Override
    public void deleteCategory(Long id) {

        //get the category by id
        Optional<Category> category = categoryRepository.findById(id);

        //throw the exception if the category is not found
        Category deleteCategory = category.orElseThrow(()->new CategoryNotFoundException("Category with id "+id +" not found"));

        if(menuRepository.existsByCategory(deleteCategory))
        {
            throw new CategoryHasMenusException(
                    "Cannot delete category because it contains menu items"
            );
        }

        //delete the category
        categoryRepository.delete(deleteCategory);

    }
}
