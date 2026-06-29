package com.jumpstart.food_ordering_system.service;

import com.jumpstart.food_ordering_system.Response.PageResponse;
import com.jumpstart.food_ordering_system.Response.Response;
import com.jumpstart.food_ordering_system.dto.CategoryDto;
import com.jumpstart.food_ordering_system.dto.MenuDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

/*
 *Defines the business operations available for menu management.
 */
public interface MenuService {

    Response<MenuDto> createMenu(MenuDto dto);
    Response<MenuDto> getMenuById(Long id);
    Response<MenuDto>  updateById(Long id, MenuDto dto);
    Response<Void>  deleteMenu(Long id);
    Response<CategoryDto> getCategoryFromMenu(Long id);

    Response<PageResponse<MenuDto>> getAllMenus(Pageable pageable);
    Response<PageResponse<MenuDto>> findMenuByCategory(Long categoryId, Pageable pageable);
    Response<PageResponse<MenuDto>> searchMenus(String search, Pageable pageable);
    Response<PageResponse<MenuDto>> findByCategoryIdSearch(Long categoryId, String search, Pageable pageable);



}
