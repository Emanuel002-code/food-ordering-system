package com.jumpstart.food_ordering_system.service;

import com.jumpstart.food_ordering_system.Response.Response;
import com.jumpstart.food_ordering_system.dto.MenuDto;
import com.jumpstart.food_ordering_system.repository.MenuRepository;

import java.util.List;

public class MenuServiceImpl implements MenuService{


    private final MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public Response<MenuDto> createMenu(MenuDto dto) {
        return null;
    }

    @Override
    public Response<List<MenuDto>> getAllMenus() {
        return null;
    }

    @Override
    public Response<MenuDto> getMenuById(Long id) {
        return null;
    }
}
