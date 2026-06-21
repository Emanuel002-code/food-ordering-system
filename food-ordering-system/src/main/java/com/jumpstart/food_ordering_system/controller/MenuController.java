package com.jumpstart.food_ordering_system.controller;


import com.jumpstart.food_ordering_system.Response.Response;
import com.jumpstart.food_ordering_system.dto.MenuDto;
import com.jumpstart.food_ordering_system.service.MenuService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {

    private  final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping("/api/menu")
    public ResponseEntity<Response<MenuDto>> create(@Valid @RequestBody MenuDto menuDto)
    {
        Response<MenuDto> response= menuService.createMenu(menuDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/api/menu")
    public  ResponseEntity<Response<List<MenuDto>>> all()
    {
        Response<List<MenuDto>> menuResponse = menuService.getAllMenus();

        return ResponseEntity.ok(menuResponse);
    }

    @GetMapping("/api/menu/{id}")
    public  ResponseEntity<Response<MenuDto>> byId(@Valid @PathVariable Long id)
    {
        Response<MenuDto> response = menuService.getMenuById(id);

        return ResponseEntity.ok(response);
    }


}
