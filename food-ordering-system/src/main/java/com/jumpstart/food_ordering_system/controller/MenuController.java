package com.jumpstart.food_ordering_system.controller;


import com.jumpstart.food_ordering_system.Response.Response;
import com.jumpstart.food_ordering_system.dto.MenuDto;
import com.jumpstart.food_ordering_system.service.MenuService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
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

   /* @GetMapping
    public  ResponseEntity<Response<List<MenuDto>>> all()
    {
        Response<List<MenuDto>> menuResponse = menuService.getAllMenus();

        return ResponseEntity.ok(menuResponse);
    }*/

    @GetMapping("/{id}")
    public  ResponseEntity<Response<MenuDto>> byId(@Valid @PathVariable Long id)
    {
        Response<MenuDto> response = menuService.getMenuById(id);

        return ResponseEntity.ok(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Response<MenuDto>> updateManu(@PathVariable Long id,@Valid @RequestBody MenuDto menuDto)
    {
        Response<MenuDto> response = menuService.updateById(id,menuDto);
        return  ResponseEntity.ok(response);
    }
    //Get all  menus  and also  get menus by categoryId
    @GetMapping
    public ResponseEntity<Response<List<MenuDto>>> getMenusByCategory(@RequestParam(required = false) Long categoryId,
                                                                      @RequestParam(required =false ) String search,
                                                                      @RequestParam(required = false) String sort)
    {
        Response<List<MenuDto>> response;
        if(search != null && categoryId !=null )
        {
            response = menuService.findByCategoryIdSearch(categoryId,search);
        }
        else if (search != null )
        {
            response= menuService.searchMenus(search);

        }
        else if(categoryId !=null)
        {
            response = menuService.findMenuByCategory(categoryId);
        }
        else if(sort != null)
        {
            response = menuService.sortByPrice(sort);
        }
        else
        {
          response = menuService.getAllMenus();
        }

           return  ResponseEntity.ok(response);

    }

}
