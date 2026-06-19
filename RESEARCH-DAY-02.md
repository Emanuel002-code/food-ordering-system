Q1. What is a Java generic type? Why is <T> useful?
Is a type which works for any data types. It makes the code reusable, and if foe safe type(no casting needed)

Q2. What does Lombok @Builder generate behind the scenes?
automatically creates a builder pattern implementation behind the scenes

Q3. What is the Builder design pattern? When to use it?
Is a creational design pattern that provides a step-by-step approach to constructing complex objects. It is used when we have many optional fields and to avoid telescoping      constructors.


Q4. What is LocalDateTime? How is it different from Date?
represents a date-time without a time zone.
Differences between Date and LocalDateTime is that LocalDateTime is  immutable, while Date is not, also Date uses Timezone, while LocalDateTime do not use Timezone.


Q5. Why does a consistent response format matter to frontend developers?
So that it can be easy for error handling. It enhance collaboration between frontend and backend developers.

Q6. What does @JsonInclude(JsonInclude.Include.NON_NULL) do?
It tells that if a field is null, it will be omitted from the JSON output.


Q7. What is a static factory method? Why use Response.success(...) instead of new Response<>()?
A static factory method is a method that creates and returns an object. We use  Response.success(...)  to control response creation in one place.

-------------------------------------API Response Format-----------------------


All API endpoints return a standard response structure to ensure consistency across the application.

     --------Success Response---------
{
  "statusCode": 200,
  "message": "Category retrieved successfully",
  "data": {
    "id": 1,
    "name": "Pizza"
  },
  "timestamp": "2026-06-19T15:30:00"
}


      -----------Error Response-------
{
    "statusCode": 404,
    "message": "Category with id 999 not found",
    "timestamp": "2026-06-19T15:35:00"
}

      ---------Response Fields-----

| Field           | Description                                   |
|-----------------|-----------------------------------------------|
| statusCode      | HTTP status code of the response              |
| message         | Human-readable response message               |
| data            | Response data(category) (if applicable)       |
| timestamp       | Date and time when the response was generated |
