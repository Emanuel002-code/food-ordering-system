1. Spring Boot is an open-source, Java-Based framework used to create a standalone, production applications easily with minimal configuration. It is mostly used to build robust backend system, including microservice, Web application and RESTful APIs.

2. Maven  is an open-source build automation and project management tool that is used to manage Java-based application. Maven automatically downloads and updates external software libraries(JAR files) from the online Maven Central Repository. It handles compilation and dependency resolutions.

3.  pom.xml (Project Object Model)  is the fundamental configuration document for any java project managed by Maven. Its purpose is to define project information, dependencies,  build configuration, project properties, and plugins.

4. application.properties is a file used to store application configuration settings. It allows you to configure your application without changing the Java code.

5. @SpringBootApplication tells the Spring Boot that this is the  main class, allow automatic configuration of the application, find and register all Spring components.

6. Developers uses dependency management tools such as Maven because it automatically handles  the dependencies, it helps them to avoid version conflicts, it enforces standard structured project, it makes the project reusable and scalable, also it is because of automation builds.

7. REST API (Representational State Transfer Application Programming Interface)  is an architectural style that allows different systems to communicate with each other using http protocol.

8. JSON (JavaScript Object Notation) is a lightweight format used to store and exchange data between systems, especially in web applications and REST APIs.

9. Dependency Injection (DI) is a  software design techniques where an object receives its required dependencies from external source rather than creating them itself.

    ------------------------------------------------purpose of packages-----------------------------------------------------------------------------------

1. controller -handles all incoming HTTP requests from clients (receives api requests, and send the response back to the client).
2. service    -contains the core business logic of the application (process data from controls, apply business rules, communicate with repositories).
3. repository -handles database operations (performs CRUD operations and communicates directly with the database).
4. entity     -represents database tables as Java classes (maps Java objects to database tables)
5. dto        -used to transfer data between layers safely (sends only required data to the client, prevents exposing database entities directly and improves security and flexibility).
6. config     -contains application configuration classes (defines beans and settings, handles security,Swagger, etc.).
7. exception  -handles application errors in a centralized way (manages execeptions, handles errors).

    ---------------------------------------Category Endpoints----------------------------------

| Method | URL                       | Body         |
|--------|---------------------------|--------------|
| POST   | /api/categories           | { "name" }   |
| GET    | /api/categories           | -            |
| GET    | /api/categories/{id}      | -            |
| PUT    | /api/categories/{id}      | { "name" }   |
| DELETE | /api/categories/{id}      | -            |

------------------------------------------Menu Endpoints--------------------------------------


| Method | Path           | Description                                                         | Query Parameters                     |
| ------ |----------------| ------------------------------------------------------------------- | ------------------------------------ |
| POST   | /api/menu      | Create a new menu item                                              | None                                 |
| GET    | /api/menu      | Retrieve menu items with optional filtering, pagination and sorting | categoryId, search, page, size, sort |
| GET    | /api/menu/{id} | Retrieve a menu item by ID                                          | None                                 |
| PUT    | /api/menu/{id} | Update a menu item                                                  | None                                 |
| DELETE | /api/menu/{id} | Delete a menu item                                                  | None                                 |

---

## Query Parameters

| Parameter  | Type    | Description                                                | Default  |
|------------| ------- | ---------------------------------------------------------- |----------|
| categoryId | Long    | Filter menus by category                                   | Optional |
| search     | String  | Case-insensitive partial search on menu name               | Optional |
| page       | Integer | Zero-based page number                                     | 0        |
| size       | Integer | Number of items per page                                   | 10       |
| sort       | String  | Sort by field and direction (e.g. price,asc or price,desc) | None     |

---

## Example Request

Retrieve page 0, with 5 menu items, filtered by category, searched by name and sorted by price.

```
GET /api/menu?categoryId=1&search=burger&page=0&size=5&sort=price,asc
```

---

## Example Response

```json
{
   "message": "Menus retrieved successfully",
   "data": {
      "content": [
         {
            "id": 7,
            "name": "Cheese Burger",
            "price": 49.99,
            "categoryId": 1,
            "categoryName": "Fast Food",
            "description": "Beef patty with cheese",
            "imageUrl": "https://placehold.co/300"
         },
         {
            "id": 10,
            "name": "Chicken Burger",
            "price": 55.00,
            "categoryId": 1,
            "categoryName": "Fast Food",
            "description": "Crispy chicken",
            "imageUrl": "https://placehold.co/300"
         },
         {
            "id": 11,
            "name": "Chicken Burger",
            "price": 55.00,
            "categoryId": 1,
            "categoryName": "Fast Food",
            "description": "Crispy chicken",
            "imageUrl": "https://placehold.co/300"
         },
         {
            "id": 12,
            "name": "Chicken Burger",
            "price": 55.00,
            "categoryId": 1,
            "categoryName": "Fast Food",
            "description": "Crispy chicken",
            "imageUrl": "https://placehold.co/300"
         },
         {
            "id": 13,
            "name": "Chicken Burger",
            "price": 55.00,
            "categoryId": 1,
            "categoryName": "Fast Food",
            "description": "Crispy chicken",
            "imageUrl": "https://placehold.co/300"
         }
      ],
      "totalElements": 6,
      "totalPages": 2,
      "number": 0,
      "size": 5,
      "first": true,
      "last": false
   },
   "statusCode": 200,
   "timestamp": "2026-06-29T10:25:55.857133"
}
```
