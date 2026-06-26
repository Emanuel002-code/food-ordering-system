package com.jumpstart.food_ordering_system.service;

import com.jumpstart.food_ordering_system.Response.PageResponse;
import com.jumpstart.food_ordering_system.Response.Response;
import com.jumpstart.food_ordering_system.dto.MenuDto;
import com.jumpstart.food_ordering_system.entity.Category;
import com.jumpstart.food_ordering_system.entity.Menu;
import com.jumpstart.food_ordering_system.exception.CategoryNotFoundException;
import com.jumpstart.food_ordering_system.exception.MenuNotFoundException;
import com.jumpstart.food_ordering_system.repository.CategoryRepository;
import com.jumpstart.food_ordering_system.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
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
    //Get all the menus
    @Override
    public Response<PageResponse<MenuDto>> getAllMenus(Pageable pageable) {

        Page<Menu> pageMenu  = menuRepository.findAll(pageable);

        Page<MenuDto> dtoPage  = pageMenu.map(this::mapToDto);

        PageResponse<MenuDto> pageResponse = PageResponse.from(dtoPage);


        return Response.success("Menus retrieved successfully", pageResponse);
    }
    // find the mene by id
    @Override
    public Response<MenuDto> getMenuById(Long id) {

        Optional<Menu> menu = menuRepository.findById(id);

        Menu foundMenu = menu.orElseThrow(()-> new MenuNotFoundException("Menu with id " + id + " not found"));

        MenuDto menuDto = mapToDto(foundMenu);


        return Response.success( "Menu retrieved successfully", menuDto);
    }

    @Override
    public Response<MenuDto> updateById(Long id, MenuDto dto) {

        Optional<Menu> menu = menuRepository.findById(id);

        Menu foundMenu = menu.orElseThrow(()-> new MenuNotFoundException("Menu item for id:" +id +" is not found"));

        Optional<Category> category = categoryRepository.findById(dto.getCategoryId());

        Category foundCategory = category.orElseThrow(()->new CategoryNotFoundException("Category for id:"+dto.getCategoryId()+" is not found "));

        //Update if the field
            foundMenu.setName(dto.getName());
            foundMenu.setPrice(dto.getPrice());
            foundMenu.setCategory(foundCategory);

        //Update if the field
       if(dto.getDescription() != null){
            foundMenu.setDescription(dto.getDescription());
        }
        else if(dto.getImageUrl() != null) {
            foundMenu.setImageUrl(dto.getImageUrl());
        }


        Menu savedMenu = menuRepository.save(foundMenu);

        MenuDto menuDto= mapToDto(savedMenu);

        return Response.success("Menu updated successfully", menuDto);
    }

    @Override
    public Response<Void> deleteMenu(Long id) {

        Optional<Menu> menu = menuRepository.findById(id);
        Menu foudMenu = menu.orElseThrow(()-> new MenuNotFoundException("Menu item for id:" +id +" is not found"));


        menuRepository.delete(foudMenu);

        return Response.success("Menu deleted", null);
    }

    //Method that will find the menus by category
    @Override
    public Response<PageResponse<MenuDto>> findMenuByCategory(Long categoryId, Pageable pageable) {


        Page<Menu> menuPage = menuRepository.findByCategoryId(categoryId, pageable);

        Page<MenuDto> dtoPage = menuPage.map(this::mapToDto);

        PageResponse<MenuDto> pageResponse = PageResponse.from(dtoPage);

        String message = "Menu items by category id: " + categoryId + " retrieved successfully";


        return Response.success(message, pageResponse);
    }

    @Override
    public Response<PageResponse<MenuDto>> searchMenus(String search, Pageable pageable) {


          Page<Menu> menus = menuRepository.findByNameContainingIgnoreCase(search, pageable);

          Page<MenuDto> menuDtos = menus.map(this::mapToDto);

          PageResponse<MenuDto> response  =  PageResponse.from(menuDtos);

        return Response.success("Menu search results for: " + search ,response);
    }

    @Override
    public Response<PageResponse<MenuDto>> findByCategoryIdSearch(Long categoryId, String search, Pageable pageable){


       Page<Menu> menus = menuRepository.findByCategoryIdAndNameContainingIgnoreCase(categoryId, search, pageable);

       Page<MenuDto> menuDto = menus.map(this::mapToDto);

       PageResponse<MenuDto> menuDtoPageResponse = PageResponse.from(menuDto);

        return Response.success("Menus retrieved successfully",menuDtoPageResponse);

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
