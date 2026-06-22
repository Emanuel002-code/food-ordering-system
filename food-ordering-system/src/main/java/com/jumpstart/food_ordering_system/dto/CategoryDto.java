package com.jumpstart.food_ordering_system.dto;

/*
  transfer data between layers safely
 */

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import javax.xml.transform.sax.SAXResult;

public class CategoryDto
{
    private Long id;
    @NotBlank(message = "Category name is required")
    @Size(min=2, max=50, message = "Name must be 2-50 characters")
    private String name;

    @Size(max = 1000, message =  "Description is too long")
    private String description;

    //default constructor
    public CategoryDto(){};

    //constructor
    public  CategoryDto(Long id, String name, String description)
    {

        this.name=name;
        this.id=id;
        this.description= description;
    }

    //getter method for id
    public Long getId()
    {
        return this.id;
    }
    //getter method for name
    public String getName() {
        return this.name;
    }
    //setter method for id
    public void setId(Long id) {
        this.id = id;
    }
    //setter method for name
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription(){return  this.description;}

     public void setDescription(String description) {
        this.description = description;
    }
}
