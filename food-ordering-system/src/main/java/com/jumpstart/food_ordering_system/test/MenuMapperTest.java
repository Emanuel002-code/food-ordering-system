package com.jumpstart.food_ordering_system.test;

import com.jumpstart.food_ordering_system.dto.MenuDto;
import com.jumpstart.food_ordering_system.entity.Category;
import com.jumpstart.food_ordering_system.entity.Menu;
import com.jumpstart.food_ordering_system.service.Helper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class MenuMapperTest {

    @Test
    public void shouldMapMenuToDtoCorrectly()
    {
        //create a category object
        Category category = new Category();
        category.setId(99L);
        category.setName("Fast food");
        category.setDescription("Cooked at a short time");

        //create a menu object
        Menu menu = new Menu();
        menu.setId(10L);
        menu.setName("Cheese Burger");
        menu.setPrice(new BigDecimal("49.99"));
        menu.setDescription("Beef burger with cheese");
        menu.setImageUrl("image.jpg");
        menu.setCategory(category);


        MenuDto dto = Helper.mapToDto(menu);
        Assertions.assertNotNull(dto);
        Assertions.assertEquals(10L, dto.getId());
        Assertions.assertEquals("Cheese Burger", dto.getName());
        Assertions.assertEquals(new BigDecimal("49.99"), dto.getPrice());
        Assertions.assertEquals("Beef burger with cheese", dto.getDescription());
        Assertions.assertEquals("image.jpg", dto.getImageUrl());
        Assertions.assertEquals(99L, dto.getCategoryId());
        Assertions.assertEquals("Fast food", dto.getCategoryName());



    }

    @Test
    void shouldMapDtoToMenuCorrectly() {

        // Arrange
        Category category = new Category();
        category.setId(99L);
        category.setName("Fast food");

        MenuDto dto = new MenuDto(
                10L,
                "Cheese Burger",
                new BigDecimal("49.99"),
                99L,
                "Fast food",
                "Beef burger with cheese",
                "image.jpg"
        );

        // Act
        Menu menu = Helper.mapToEntity(dto, category);

        // Assert
        Assertions.assertNotNull(menu);
        Assertions.assertEquals("Cheese Burger", menu.getName());
        Assertions.assertEquals("Beef burger with cheese", menu.getDescription());
        Assertions.assertEquals(new BigDecimal("49.99"), menu.getPrice());
        Assertions.assertEquals("image.jpg", menu.getImageUrl());
        Assertions.assertEquals(category, menu.getCategory());
    }

}
