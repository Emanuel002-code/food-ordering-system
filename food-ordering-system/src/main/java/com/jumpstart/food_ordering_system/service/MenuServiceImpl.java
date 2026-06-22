package com.jumpstart.food_ordering_system.service;

import com.jumpstart.food_ordering_system.Response.Response;
import com.jumpstart.food_ordering_system.dto.MenuDto;
import com.jumpstart.food_ordering_system.entity.Category;
import com.jumpstart.food_ordering_system.entity.Menu;
import com.jumpstart.food_ordering_system.exception.CategoryNotFoundException;
import com.jumpstart.food_ordering_system.exception.MenuNotFoundException;
import com.jumpstart.food_ordering_system.repository.CategoryRepository;
import com.jumpstart.food_ordering_system.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor   //Auto create a constructor
public class MenuServiceImpl implements MenuService{


    private final MenuRepository menuRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Response<MenuDto> createMenu(MenuDto dto) {

        Optional<Category> category = categoryRepository.findById(dto.getCategoryId());
        Category foundCategory= category.orElseThrow(()-> new CategoryNotFoundException("Category with id " + dto.getId() + " not found"));

        //maps menuDto -> menu using the helper function
        Menu menu = this.mapToEntity(dto, foundCategory);

        Menu savedMenu = menuRepository.save(menu);

        //maps menu -> menuDto using the helper function
        MenuDto menuDto = this.mapToDto(savedMenu);


       return Response.success("Menu created successfully",menuDto);
    }
   // Get all the menus
    @Override
    public Response<List<MenuDto>> getAllMenus() {

        List<MenuDto> menus = menuRepository.findAll()
                                         .stream().map(this::mapToDto).toList();

        return Response.success("Menus retrieved successfully", menus);
    }
    // find the mene by id
    @Override
    public Response<MenuDto> getMenuById(Long id) {

        Optional<Menu> menu = menuRepository.findById(id);

        Menu foundMenu = menu.orElseThrow(()-> new MenuNotFoundException("Menu with id " + id + " not found"));

        MenuDto menuDto = mapToDto(foundMenu);


        return Response.success( "Menu retrieved successfully", menuDto);
    }
 //Helper method that maps the menus to manuDto
    private MenuDto mapToDto(Menu menu) {

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
    private Menu mapToEntity(MenuDto dto, Category category) {

        Menu menu = new Menu();
        menu.setName(dto.getName());
        menu.setDescription(dto.getDescription());
        menu.setPrice(dto.getPrice());
        menu.setImageUrl(dto.getImageUrl());
        menu.setCategory(category);

        return menu;
    }
}
