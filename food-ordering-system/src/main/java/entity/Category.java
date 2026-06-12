package entity;

import jakarta.persistence.*;
import lombok.Setter;


@Setter //use lombok to  auto create set methods
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;

    //default constructor of  category class
    public Category(){}

    //constructor or category class
    public Category(Long id, String name)
    {
        this.name=name;
        this.id=id;
    }
    // getter method for id
    public Long getId(Long id)
    {
        return this.id;
    }
    //getter method for name
    public String getName(String name)
    {
        return  this.name;
    }
}
