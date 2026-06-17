Q1. CRUD stand for:
C-Create, operation that will enable us to add new data to the system
R-Read, operation that get the data without modifying it
U-Update, operation that modifying the existing data
D-Delete, operation that removing data from the system

Q2. Difference between HTTP methods POST, PUT, PATCH, DELETE.
POST- add data to the system
PUT- replace the existing data completely
PATCH- update part of the existing data
DELETE - removes data from the system

Q3. HTTP status code for each:
a. A new category was created - 201 Created
b. A category was deleted successfully - 204 No Content
c. The id requested does not exist -  404 Not Found
d. The request body is missing a required field - 400 Bad Request
e. The user is logged in but not allowed -  403 Forbidden

Q4. Difference between @RequestBody, @RequestParam, @PathVariable -and example of each.

These annotations are used to get data from an HTTP request in Spring Boot from different places.

@RequestBody- Used to read data from the request body (usually JSON).
POST /categories
{
"name": "Burgers"
}

@RequestParam- Used to read data from the URL query string.
GET /categories?name=Burgers

@PathVariable- Used to read data from the URL path itself.
GET /categories/5

Q5. Jakarta Bean Validation defination and Explanation of @Valid,  @NotBlank, @Size.

Jakarta Bean Validation is a standard way in Spring Boot to validate object data automatically before it reaches business logic.

@Valid - Used in controller methods to trigger validation on an object.
@NotBlank - Used to ensure a String is not null, not empty, and not just spaces.
@Size - Used to enforce minimum and maximum length of a field.

Q6. Why return a DTO and not the entity itself? Give 2 reasons.
- Because we do not want to expose the sensitive data that Entity contain.
- Because we want to make the API flexible, so if we expose the entity, since the entity is tied to the database, any changes we make might break the API.

Q7. What is Optional<T>.  and why does findById return Optional.
Optional<T> is a container object in Java that may or may not contain a value.  The reason why findById return Optional is because we might not find the Id we are searching in the database.