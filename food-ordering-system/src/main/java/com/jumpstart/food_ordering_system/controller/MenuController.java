package com.jumpstart.food_ordering_system.controller;


import com.jumpstart.food_ordering_system.Response.PageResponse;
import com.jumpstart.food_ordering_system.Response.Response;
import com.jumpstart.food_ordering_system.dto.CategoryDto;
import com.jumpstart.food_ordering_system.dto.MenuDto;
import com.jumpstart.food_ordering_system.service.MenuService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/menu")
@Validated
public class MenuController {

    private  final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping
    public ResponseEntity<Response<MenuDto>> create(@Valid @RequestBody MenuDto menuDto)
    {
        Response<MenuDto> response= menuService.createMenu(menuDto);

        return ResponseEntity.ok(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Response<MenuDto>> updateManu(@PathVariable Long id,@Valid @RequestBody MenuDto menuDto)
    {
        Response<MenuDto> response = menuService.updateById(id,menuDto);
        return  ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<Response<MenuDto>> byId(@Valid @PathVariable Long id)
    {
        Response<MenuDto> response = menuService.getMenuById(id);

        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}/category")
    public  ResponseEntity<Response<CategoryDto>> getCategoryFromMenu(@PathVariable Long id)
    {
           Response<CategoryDto> response = menuService.getCategoryFromMenu(id);

           return ResponseEntity.ok(response);
    }
    //Get all  menus, get menus by categoryId, sort by price(ASC, DESC,)
    @GetMapping
    public ResponseEntity<Response<PageResponse<MenuDto>>> getMenus(@RequestParam(required = false) Long categoryId,
                                                                    @RequestParam(required =false ) String search,

                                                                    @RequestParam(defaultValue = "0") int page,
                                                                    @RequestParam(defaultValue = "10")  @Min(value = 1, message = "Size must be at least 1") int size,
                                                                    Pageable pageable)

    {
        Pageable finalPageable  =  PageRequest.of(page, size, pageable.getSort());
        Response<PageResponse<MenuDto>> response;
       if(search != null && categoryId !=null )
        {
            response = menuService.findByCategoryIdSearch(categoryId,search, finalPageable);
        }
         else if (search != null )
        {
            response= menuService.searchMenus(search, finalPageable);

        }
        else if(categoryId !=null)
        {
            response = menuService.findMenuByCategory(categoryId, finalPageable);
        }
        else
        {
          response = menuService.getAllMenus(finalPageable);
        }

           return  ResponseEntity.ok(response);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Void>> deleteMenuItem(@PathVariable Long id)
    {
        Response<Void> response  = menuService.deleteMenu(id);

        return ResponseEntity.ok(response);
    }


}
