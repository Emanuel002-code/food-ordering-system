package dto;

public class CategoryDto
{
    private Long id;
    private String name;

    //default constructor
    public CategoryDto(){};

    //constructor
    public  CategoryDto(Long id,String name)
    {

        this.name=name;
        this.id=id;
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
}
