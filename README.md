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
