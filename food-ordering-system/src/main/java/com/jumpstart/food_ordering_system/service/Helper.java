package com.jumpstart.food_ordering_system.service;

import com.jumpstart.food_ordering_system.dto.MenuDto;
import com.jumpstart.food_ordering_system.entity.Category;
import com.jumpstart.food_ordering_system.entity.Menu;


public class Helper {

    //Helper method that maps the menus to manuDto
    public static  MenuDto mapToDto(Menu menu) {

        return new MenuDto(
                menu.getId(),
                menu.getName(),
                menu.getPrice(),
                menu.getCategory().getId(),
                menu.getCategory().getName(),
                menu.getDescription(),
                menu.getImageUrl()
        );
    }

    //Helper method that maps the manuDto to menu
    public static  Menu mapToEntity(MenuDto dto, Category category) {

        Menu menu = new Menu();
        menu.setName(dto.getName());
        menu.setDescription(dto.getDescription());
        menu.setPrice(dto.getPrice());
        menu.setImageUrl(dto.getImageUrl());
        menu.setCategory(category);

        return menu;
    }

}
