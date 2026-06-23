package com.jumpstart.food_ordering_system.service;

import com.jumpstart.food_ordering_system.Response.Response;
import com.jumpstart.food_ordering_system.dto.MenuDto;

import java.util.List;

/*
 *Defines the business operations available for menu management.
 */
public interface MenuService {

    Response<MenuDto> createMenu(MenuDto dto);
   // Response<List<MenuDto>> getAllMenus();
    Response<MenuDto> getMenuById(Long id);
    Response<MenuDto>  updateById(Long id, MenuDto dto);
    Response<Void>  deleteMenu(Long id);
    Response<List<MenuDto>> findMenuByCategory(Long categoryId);

}
