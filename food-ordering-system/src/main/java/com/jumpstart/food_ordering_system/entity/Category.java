package com.jumpstart.food_ordering_system.entity;
/*
 * maps Java objects to database tables
 * Each category is stored in the category database table.
 */
import jakarta.persistence.*;
import lombok.Setter;


@Setter //use lombok to  auto create set methods
@Entity
@Table(name = "category")
public class Category {

    /*
        Unique identifier for the category, generated automatically
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
    private String description;

    //default constructor of  category class
    public Category(){}

    //parameterized constructor or category class
    public Category(Long id, String name, String description)
    {
        this.name=name;
        this.id=id;
        this.description= description;
    }
    /* getter method for id
      @return id
    */
    public Long getId()
    {
        return this.id;
    }
    /*getter method for name
     @return name
     */
    public String getName()
    {
        return  this.name;
    }

    public String getDescription() {
        return description;
    }
}
