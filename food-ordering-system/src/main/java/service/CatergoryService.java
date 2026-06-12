package service;

import dto.CategoryDto;

import java.util.List;
/*
   Interface for  storing all categories into the list
 */
public interface CatergoryService {

    List<CategoryDto> getAllCategories();
}
