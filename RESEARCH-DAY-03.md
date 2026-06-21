Q1.  What is JPA? What is Hibernate? How are they related?
     JPA defines how application should manage data store in relation of the database.
     Hibernate is a framework for Java that simplifies database operations by mapping Java objects to database tables. It communicates with the database.
     The relationship is that JPA defines the standard, while Hibernate implements it.

Q2.  What is the difference between @Entity and @Table?
     @Entity marks a Java class as a JPA entity that should be persisted to the database.
     @Table specifies the database table name and table details for the entity.

Q3.  What is a foreign key? What is @ManyToOne? Give 2 real-world examples.
     Foreign key is a column in one table that references the primary key of another table. It provides a relationship between tables.
     @ManyToOne is a JPA annotation used to represent a relationship where many records in one table belong to one record in another table.

       Examples: Many products belong to one category
                 Cheeseburger   - Burger
                 Chicken burger - Burger
                 BBQ Burger     - Burger

Q4.  What does @JoinColumn(name = "category_id") do?
     @JoinColumn specifies the foreign key column used to link two entities in a relationship.


Q5.  Why store price as BigDecimal and not double?
     Because  double makes floating-point rounding error, which makes it inaccurate for financial calculation. So BigDecimal provides exact precision.

Q6.  What does FetchType LAZY vs EAGER mean? What is the default for @ManyToOne?
     Using FetchType.EAGER- When you load an entity, its related entities are loaded immediately too.
     Using FetchType.LAZY - When you load an entity, related data is not loaded immediately. It is loaded only when you access it.
     @ManyToOne is LAZY by default

Q7.  What is the N+1 query problem?
     Is problem were JPA execute one query to load parent entities then execute N additional queries to load related child entities.


Q8.  What is dependency injection? Constructor injection vs field injection — which is preferred and why?
     Dependency Injection is a design pattern where objects receive their dependencies from outside instead of creating them internally.
     Constructor injection is preferred over field injection because it makes dependencies explicit, supports immutability, improves testability, and avoids hidden coupling.
     Field injection is less recommended because it hides dependencies and is harder to test.


Q9.  What does @RequiredArgsConstructor (Lombok) do?
     @RequiredArgsConstructor is a Lombok annotation that automatically generates a constructor for all final and @NonNull fields in a class.

Q10. What is the role of the SERVICE layer? Why must it be separate from the controller?
     The service layer contains the business logic of the application, while the Controller handles HTTP requests and responses.
     They must be separate to improve code reusability, make testing easier, and keep controllers clean.


Q11. Why MUST you validate that categoryId exists before saving a menu?
     Because of data integrity, correctness, and database safety.

Q12. Difference between save() and saveAndFlush()?
     Saves the entity in the persistence context (Hibernate cache) so SQL is not immediately executed, while saveAndFlush() saves the entity and immediately flushes changes to the    database.


Q13. Why write private mapper methods (entity <-> dto)?
     Private mapper methods are used to convert between Entity and DTO within a service class.
     They improve code readability, reduce duplication, and separate data transformation from business logic.
     Making them private ensures encapsulation, since they are only used internally and not part of the service’s public API.
