package com.jumpstart.food_ordering_system.dto;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/*
 * Used to transfer menu data between client and server
 */
@Setter
@Getter
public class MenuDto {


    private Long id;
    @NotBlank(message = "Menu name is required")
    private String name;

    @NotNull(message = "Price is required")  @DecimalMin("0.0")
    private BigDecimal price;

    @NotNull(message = "Category ID is required")
    private Long categoryId;

    private String categoryName;

    @Size(max=1000, message = "Description cannot exceed 1000 characters")
    private  String description;

    private  String imageUrl;

    /*
     *No args constructor
     */
    public   MenuDto(){}

    /*
     *parameterized constructor
     */
  public MenuDto(Long id, String name, BigDecimal price,
                 Long categoryId, String categoryName, String description, String imageUrl )
  {
      this.id=id;
      this.name=name;
      this.price=price;
      this.categoryId=categoryId;
      this.categoryName=categoryName;
      this.description=description;
      this.imageUrl=imageUrl;
  }

}
